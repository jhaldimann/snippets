package com.mentoring.snippets.controller;

import com.mentoring.snippets.model.Member;
import com.mentoring.snippets.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/members/")
public class MemberController implements IMemberController {
    private MemberService memberService;

    @Override
    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public Member getMember(String id) {
        return this.memberService.getMember(id);
    }

    @Override
    public Member saveMember(Member memberToSave) {
        return this.memberService.saveMember(memberToSave);
    }

    @Override
    public Member updateMember(Member memberToUpdate, String id) {
        return null;
    }

    @Override
    public void deleteMember(String id) {

    }
}
