/*
package com.core.security;

import com.core.utils.StringUtils;
import io.jsonwebtoken.Claims;
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
import java.util.List;


@Component
public class JWTTokenAuthenticationFilter extends OncePerRequestFilter {
    //token header
    private static String TOKEN_HEADER = "token";


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(TOKEN_HEADER);
        if (request.getRequestURL().toString().contains("/api/user/save") || request.getRequestURL().toString().contains("/api/user/query")|| request.getRequestURL().toString().contains("/druid")) {
            List<SimpleGrantedAuthority> auths = new ArrayList<>();
            auths.add(new SimpleGrantedAuthority("ADMIN"));
            // 构建返回的用户登录成功的token
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken("admin", null, auths);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else if (StringUtils.isNotBlank(token) && !JWTTokenUtils.isExpiration(token, null)) {
            Claims claims = JWTTokenUtils.parserToken(token, null);
            String userName = (String) claims.get("userName");
            List<SimpleGrantedAuthority> auths = new ArrayList<>();
            auths.add(new SimpleGrantedAuthority("ADMIN"));
            // 构建返回的用户登录成功的token
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userName, null, auths);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            logger.error("token is invalid,please login");
            throw new RuntimeException("token is invalid,please login");
        }
        filterChain.doFilter(request, response);
    }
}
*/
