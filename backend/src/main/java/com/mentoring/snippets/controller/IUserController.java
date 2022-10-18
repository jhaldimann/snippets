package com.mentoring.snippets.controller;

import com.mentoring.snippets.model.User;
import com.mentoring.snippets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public interface IUserController {
    @Autowired
    void setMemberService(UserService userService);

    @RequestMapping(path = "{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    User getMember(@PathVariable(name = "username") String username);

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/")
    User saveMember(@RequestBody User userToSave);

    @RequestMapping(path = "{username}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    User updateMember(@RequestBody User userToUpdate, @PathVariable(name = "username") String username);

    @RequestMapping(path = "{username}", method = RequestMethod.DELETE)
    @DeleteMapping("/{username}")
    void deleteMember(@PathVariable(name = "username") String username);
}
