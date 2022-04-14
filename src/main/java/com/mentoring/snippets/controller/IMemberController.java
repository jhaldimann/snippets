package com.mentoring.snippets.controller;

import com.mentoring.snippets.model.Member;
import com.mentoring.snippets.model.Snippet;
import com.mentoring.snippets.service.MemberService;
import com.mentoring.snippets.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public interface IMemberController {
    @Autowired
    void setMemberService(MemberService memberService);

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    Member getMember(@PathVariable(name = "id") String id);

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/")
    Member saveMember(@RequestBody Member memberToSave);

    @RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Member updateMember(@RequestBody Member memberToUpdate, @PathVariable(name = "id") String id);

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    void deleteMember(@PathVariable(name = "id") String id);
}
