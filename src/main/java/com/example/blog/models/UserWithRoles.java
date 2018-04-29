package com.example.blog.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserWithRoles extends User implements UserDetails{
    private List<String> userRoles;

    public UserWithRoles(User user) {
        super(user);  // Call the copy constructor defined in User

    }

    public UserWithRoles (User user, List<String> userRoles) {
        super(user);
        this.userRoles = userRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();


        if (getUsername().equalsIgnoreCase("ted")) {
            list.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));
        } else {
            list.add(new SimpleGrantedAuthority("ROLE_" + "USER"));
        }

        return list;
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
