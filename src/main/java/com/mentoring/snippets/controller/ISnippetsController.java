package com.mentoring.snippets.controller;

import com.mentoring.snippets.model.Snippet;
import com.mentoring.snippets.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ISnippetsController {
    @Autowired
    void setSnippetService(SnippetService snippetService);

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    Snippet getSnippet(@PathVariable(name = "id") String id);

    @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/")
    List<Snippet> getSnippets();

    @RequestMapping(path = "/userid/{userid}", method = RequestMethod.GET)
    @GetMapping("/")
    List<Snippet> getSnippetsByUserId(@PathVariable(name="userid") String id);

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/")
    Snippet saveSnippet(@RequestBody Snippet snippetToSave);

    @RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Snippet updateSnippet(@RequestBody Snippet snippetToUpdate, @PathVariable(name = "id") String id);

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    @DeleteMapping("{id}")
    void deleteSnippet(@PathVariable(name = "id") String id);
}
