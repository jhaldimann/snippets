package com.mentoring.snippets.controller;


import com.mentoring.snippets.security.JwtUtils;
import com.mentoring.snippets.utilities.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/token")
public class TokenController {

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
