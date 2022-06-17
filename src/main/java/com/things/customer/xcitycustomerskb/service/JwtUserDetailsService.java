package com.things.customer.xcitycustomerskb.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    String dbUsername = "lucy";
    String encodedPassword = bCryptHashPassword("password");

    public static String bCryptHashPassword(String password_plaintext) {
        int workload = 12;
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);
        System.out.println("hash password >>>  " + hashed_password);
        return hashed_password;
    }

    @Override
    public UserDetails loadUserByUsername(String sessionUser) throws UsernameNotFoundException {
        if (dbUsername.equals(sessionUser)) {
            return new User(dbUsername, encodedPassword, new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + sessionUser);
        }
    }
}
