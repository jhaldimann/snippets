package com.mentoring.snippets.security;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class TokenManager implements Serializable {

    private String jwtSecret;

    public String generateToken() {
        return "abc";
    }

}
