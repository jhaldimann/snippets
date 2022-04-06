package com.mentoring.snippets.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnippetController {
    @RequestMapping(path = "/")
    public String hello(Model model) {
        model.addAttribute("message", "Hello from Spring MVC Thymeleaf!");
        return "hello";
    }
}