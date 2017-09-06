package com.darkbit.sample.rest;

import com.darkbit.sample.security.jwt.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {


    @Autowired
    private UserDetailsService userDetailsService;


    @GetMapping(value = "/user/info")
    public JwtUser getUserInfo( Principal principal){

           return new JwtUser( userDetailsService.loadUserByUsername(principal.getName()));
    }
}
