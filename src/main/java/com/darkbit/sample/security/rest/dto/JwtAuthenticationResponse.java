package com.darkbit.sample.security.rest.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class JwtAuthenticationResponse implements Serializable{
    private static final long serialVersionUID = -878582066721309400L;
    private String token;


    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }
}
