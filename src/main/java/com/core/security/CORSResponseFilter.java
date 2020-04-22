package com.core.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class CORSResponseFilter implements Filter {

    public void destroy() {
    }

    /****
     * 通过拦截器解决跨域问题
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, PATCH, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "accept, authorization,x-requested-with,x-auth-token,content-type,X-XSRF-TOKEN");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Expose-Headers", "x-auth-token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        if (!request.getMethod().equalsIgnoreCase("OPTIONS")) {
            chain.doFilter(req, res);
        }
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}
