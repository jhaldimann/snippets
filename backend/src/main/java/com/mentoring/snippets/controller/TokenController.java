package com.mentoring.snippets.controller;


import com.mentoring.snippets.security.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/token")
public class TokenController {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Autowired
    private JwtUtils jwtUtils;

    @CrossOrigin
    @PostMapping()
    public HashMap<String, String> getToken(@CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        HashMap<String, String> res = new HashMap<>();
        res.put("token", jwtUtils.generateToken(user));
        return res;
    }
}
