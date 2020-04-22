package com.core.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    private Logger logger = LoggerFactory.getLogger(MyAuthenticationProvider.class);

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String userName = auth.getName();
        String password = (String) auth.getCredentials();
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(userName);
        if (userDetails == null) {
            logger.error("user name is not right！");
            throw new UsernameNotFoundException("user name is not right！");
        } else {
            roles.add(new SimpleGrantedAuthority("ADMIN"));
        }
        // 构建返回的用户登录成功的token
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, password, roles);
        token.setDetails(userDetails);
        return token;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        // 这里直接改成return true;表示是支持这个执行
        return true;
    }
}
