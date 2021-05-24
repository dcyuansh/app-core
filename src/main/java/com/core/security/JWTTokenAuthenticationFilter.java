
package com.core.security;

import com.core.utils.JWTTokenUtils;
import com.core.utils.StringUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class JWTTokenAuthenticationFilter extends OncePerRequestFilter {

    //token header
    @Value("${jwt.token.header}")
    private String TOKEN_HEADER;

    @Value("${jwt.token.exempt.url}")
    private String exemptUrl;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(TOKEN_HEADER);

        Boolean isExempt = false;
        //获取当前url
        String currentURL = request.getRequestURL().toString();
        //判断下面的url请求是不是需要豁免的资源
        StringBuffer exemptUrlBuff = new StringBuffer("druid,swagger,webjars,v2,favicon.ico,.ico,.css,.js");
        //添加其余系统豁免url
        if (StringUtils.isNotBlank(exemptUrl)) {
            exemptUrlBuff.append("," + exemptUrl);
        }
        List<String> exemptList = new ArrayList();
        exemptList.addAll(Arrays.asList(StringUtils.delimitedToArray(exemptUrlBuff.toString(), ",")));
        for (String exempt : exemptList) {
            if (currentURL.contains(exempt)) {
                isExempt = true;
                break;
            }
        }
        //对于没有得到豁免的url请求需要进行token验证
        if (!isExempt) {
            if (StringUtils.isNotBlank(token) && !JWTTokenUtils.isExpiration(token, null)) {
                Claims claims = JWTTokenUtils.parserToken(token, null);
                String userName = (String) claims.get("userName");
                List<SimpleGrantedAuthority> auths = new ArrayList<>();
                auths.add(new SimpleGrantedAuthority("admin"));
                // 构建返回的用户登录成功的token
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userName, null, auths);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                logger.error("token is invalid,please login");
                throw new RuntimeException("token is invalid,please login");
            }
        }
        filterChain.doFilter(request, response);
    }
}

