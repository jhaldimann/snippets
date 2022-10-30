package com.mentoring.snippets.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @CrossOrigin
    @GetMapping()
    public String getBackendIp() {
        return System.getenv("HOST");
    }
}
