package com.mentoring.snippets.service;

import com.mentoring.snippets.model.Member;
import com.mentoring.snippets.model.Snippet;
import com.mentoring.snippets.repository.MemberRepository;
import com.mentoring.snippets.repository.SnippetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final Logger LOG = LoggerFactory.getLogger(SnippetService.class);

    private MemberRepository memberRepository;

    @Autowired
    public void setMemberRepositoryRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member getMember(String id) {
        LOG.info("Getting the member with given id:" + id);
        return memberRepository.findById(id).orElse(null);
    }

    public Member saveMember(Member member) {
        Member memberToSave;
        try {
            memberToSave = memberRepository.save(member);
            return memberToSave;
        } catch (Exception e) {
            LOG.error("An error occurred during product saving:" + e.getMessage());
        }
        return new Member();
    }

    public Member updateMember(Member memberToUpdate, String id) {
        Member foundMember = memberRepository.findById(id).orElse(null);
        try {
            foundMember.setUsername(memberToUpdate.getUsername());
            return memberRepository.save(foundMember);
        } catch (Exception e) {
            LOG.error("An error pccurred during update of product" + e.getMessage());
        }
        return memberToUpdate;
    }

    public void deleteMember(String id) {
        try {
            memberRepository.deleteById(id);
        } catch (Exception e) {
            LOG.error("An error occurred during deleting of product:" + e.getMessage());
        }
    }
}
