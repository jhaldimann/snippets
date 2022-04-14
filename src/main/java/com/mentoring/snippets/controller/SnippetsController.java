package com.mentoring.snippets.controller;


import com.mentoring.snippets.model.Snippet;
import com.mentoring.snippets.service.SnippetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/snippets/")
public class SnippetsController implements ISnippetsController {
    private SnippetService snippetService;

    private final Logger LOG = LoggerFactory.getLogger(SnippetsController.class);

    @Override
    @Autowired
    public void setSnippetService(SnippetService snippetService) {
        this.snippetService = snippetService;
    }

    @Override
    public Snippet getSnippet(String id) {
        return snippetService.getSnippet(id);
    }

    @Override
    public Snippet saveSnippet(Snippet snippetToSave) {
        return snippetService.saveSnippet(snippetToSave);
    }

    @Override
    public Snippet updateSnippet(Snippet snippetToUpdate, String id) {
        return snippetService.updateSnippet(snippetToUpdate, id);
    }

    @Override
    public void deleteSnippet(String id) {
        snippetService.deleteSnippet(id);
    }
}