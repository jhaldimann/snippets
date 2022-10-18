package com.mentoring.snippets;

import com.mentoring.snippets.security.JwtUtils;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

public class JwtUtilsTest {
    private JwtUtils jwtUtils;

    @BeforeEach
    public void setUp() {
        jwtUtils = new JwtUtils();
    }

    @Test
    public void getJWTToken() {
        Map<String, Object> infos = new HashMap<>();
        infos.put("USERNAME", "Tester");
    }
}
