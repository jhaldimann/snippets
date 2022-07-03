package com.mentoring.snippets.controller;

import com.mentoring.snippets.utilities.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping()
    public String getToken(@CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return jwtUtil.generateToken(user.getUsername());
    }
}
