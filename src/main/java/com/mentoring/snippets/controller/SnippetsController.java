package com.mentoring.snippets.controller;


import com.mentoring.snippets.model.Snippet;
import com.mentoring.snippets.repository.SnippetRepository;
import com.mentoring.snippets.service.SnippetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/snippets/")
@Api(value = "SnippetControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class SnippetsController {
    private SnippetService snippetService;

    private Logger LOG = LoggerFactory.getLogger(SnippetsController.class);

    @Autowired
    public void setProductsService(SnippetService snippetService) {
        this.snippetService = snippetService;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ApiOperation("Gets the product with specific id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Snippet.class)})
    public Snippet getSnippet(@PathVariable(name = "id") String id) {
        return snippetService.getSnippet(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Snippet saveSnippet(@RequestBody Snippet snippetToSave) {
        return snippetService.saveSnippet(snippetToSave);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Snippet updateSnippet(@RequestBody Snippet snippetToUpdate, @PathVariable(name = "id") String id) {
        return snippetService.updateSnippet(snippetToUpdate, id);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteSnippet(@PathVariable(name = "id") String id) {
        snippetService.deleteSnippet(id);
    }
}