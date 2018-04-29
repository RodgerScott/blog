package com.example.blog.services;

import com.example.blog.models.User;
import com.example.blog.models.UserWithRoles;
import com.example.blog.repositories.Roles;
import com.example.blog.repositories.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final Users users;
    private final Roles roles;

    public UserDetailsLoader(Users users, Roles roles) {
        this.users = users;
        this.roles = roles;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }
        return new UserWithRoles(user, roles.ofUserWith(username));
    }
}
