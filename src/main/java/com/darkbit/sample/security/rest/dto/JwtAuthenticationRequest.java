package com.darkbit.sample.security.rest.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtAuthenticationRequest implements Serializable{

    private static final long serialVersionUID = -5018423271406037061L;
    private String username;
    private String password;
}
