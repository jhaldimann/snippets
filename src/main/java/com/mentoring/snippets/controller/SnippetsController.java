package com.mentoring.snippets.controller;


import com.mentoring.snippets.model.Snippet;
import com.mentoring.snippets.repository.SnippetRepository;
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
public class SnippetsController {
    private SnippetService snippetService;

    private Logger LOG = LoggerFactory.getLogger(SnippetsController.class);

    @Autowired
    public void setProductsService(SnippetService snippetService) {
        this.snippetService = snippetService;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public Snippet getSnippet(@PathVariable(name = "id") String id) {
        return snippetService.getSnippet(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/")
    public Snippet saveSnippet(@RequestBody Snippet snippetToSave) {
        return snippetService.saveSnippet(snippetToSave);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Snippet updateSnippet(@RequestBody Snippet snippetToUpdate, @PathVariable(name = "id") String id) {
        return snippetService.updateSnippet(snippetToUpdate, id);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    @DeleteMapping("{id}")
    public void deleteSnippet(@PathVariable(name = "id") String id) {
        snippetService.deleteSnippet(id);
    }
}