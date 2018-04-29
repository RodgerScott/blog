package com.example.blog.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserWithRoles extends User implements UserDetails{
    private List<String> roles;

    public UserWithRoles(User user) {
        super(user);  // Call the copy constructor defined in User

    }

    public UserWithRoles (User user, List<String> userRoles) {
        super(user);
        this.roles = userRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        String rolesString = "";
        for(String role : roles) {
            rolesString += "ROLE_" + role + ",";
        }
        return AuthorityUtils.commaSeparatedStringToAuthorityList(rolesString);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
