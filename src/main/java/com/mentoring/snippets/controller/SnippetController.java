package com.mentoring.snippets.controller;

import com.mentoring.snippets.model.Snippet;
import com.mentoring.snippets.repository.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnippetController {
    private SnippetRepository snippetRepository;

    @Autowired
    public void productRepository(SnippetRepository snippetRepository) {
        this.snippetRepository = snippetRepository;
    }

    @RequestMapping(path = "/create")
    public String create(Model model) {
        Snippet snippet = new Snippet();
        snippet.setText("Test 12345");
        snippet.setCategory("Test");
        snippet.setLanguage("Java");
        this.snippetRepository.save(snippet);
        return "hello";
    }
}