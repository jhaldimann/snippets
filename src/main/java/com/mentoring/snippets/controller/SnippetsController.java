package com.mentoring.snippets.controller;


import com.mentoring.snippets.model.Snippet;
import com.mentoring.snippets.service.SnippetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/snippets/")
@Slf4j
public class SnippetsController implements ISnippetsController {
    private SnippetService snippetService;

    @Override
    @Autowired
    public void setSnippetService(SnippetService snippetService) {
        this.snippetService = snippetService;
    }

    @Override
    @PreAuthorize("#username == authentication.getPrincipal().username")
    public List<Snippet> getSnippetsByUsername(String username) {
        return snippetService.getSnippetsByUsername(username);
    }

    @Override
    public Snippet updateSnippet(Snippet snippet) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if(!authentication.getName().equals(snippet.getUsername())) {
            return null;
        }
        return snippetService.updateSnippet(snippet);
    }

    @Override
    public void update(Snippet snippet) {
        log.info(snippet.toString());
    }

    @Override
    public Snippet saveSnippet(Snippet snippetToSave) {

        return snippetService.saveSnippet(snippetToSave);
    }

    @Override
    public void deleteSnippet(String id) {
        snippetService.deleteSnippet(id);
    }
}