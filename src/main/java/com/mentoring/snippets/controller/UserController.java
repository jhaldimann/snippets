package com.mentoring.snippets.controller;

import com.mentoring.snippets.model.User;
import com.mentoring.snippets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/members/")
public class UserController implements IUserController {
    private UserService userService;

    @Override
    @Autowired
    public void setMemberService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getMember(String id) {
        return this.userService.getMember(id);
    }

    @Override
    public User saveMember(User userToSave) {
        return this.userService.saveMember(userToSave);
    }

    @Override
    public User updateMember(User userToUpdate, String id) {
        return null;
    }

    @Override
    public void deleteMember(String id) {

    }
}
