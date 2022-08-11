package com.mentoring.snippets.controller;

import com.mentoring.snippets.model.Snippet;
import com.mentoring.snippets.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ISnippetsController {
    @Autowired
    void setSnippetService(SnippetService snippetService);

    @RequestMapping(path = "/username/{username}", method = RequestMethod.GET)
    @GetMapping("/")
    List<Snippet> getSnippetsByUsername(@PathVariable(name="username") String username);

    @RequestMapping(path = "/username/{username}", method = RequestMethod.PUT)
    @PutMapping("/{username}")
    Snippet updateSnippetByUsername(@PathVariable(name="username") String username, @RequestBody Snippet snippet);

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/")
    Snippet saveSnippet(@RequestBody Snippet snippetToSave);

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    @DeleteMapping("{id}")
    void deleteSnippet(@PathVariable(name = "id") String id);
}
