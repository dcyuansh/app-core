package com.core.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class SecurityUtils {

    private static final Logger LOG = LoggerFactory.getLogger(SecurityUtils.class);

    private SecurityUtils() {
    }


    /**
     * @return get the login of the current user.
     */
    public static String getCurUsername() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            LOG.debug("no authentication in security context found");
            return "";
        }
        String username = (String) authentication.getPrincipal();
        return username;
    }
}
