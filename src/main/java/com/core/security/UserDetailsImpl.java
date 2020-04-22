package com.core.security;

import com.core.data.model.DataModel;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EntityScan
public class UserDetailsImpl implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private DataModel userModel;

    public UserDetailsImpl(DataModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        /*
         * List<user> user = this.getRoles(); for (Role role : roles) { auths.add(new
         * SimpleGrantedAuthority(role.getMark())); }
         */
        auths.add(new SimpleGrantedAuthority("ADMIN"));
        return auths;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return userModel.getStringValue("password");
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return userModel.getStringValue("userName");
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
