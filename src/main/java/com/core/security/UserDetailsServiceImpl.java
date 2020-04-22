package com.core.security;

import com.common.usermanage.service.UserService;
import com.core.data.model.DataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


    @Autowired
    public UserService userService;

    @Override
    public UserDetailsImpl loadUserByUsername(String userName) throws UsernameNotFoundException {
        DataModel queryModel = new DataModel();
        queryModel.setFieldValue("userName", userName);
        DataModel userModel = userService.findUser(queryModel);
        if (userModel == null) {
            logger.error("not find user " + userName + " info!");
            throw new UsernameNotFoundException("not find user " + userName + " info!");
        }
        return new UserDetailsImpl(userModel);
    }
}