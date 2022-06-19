package com.mentoring.snippets.service;

import com.mentoring.snippets.model.User;
import com.mentoring.snippets.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setMemberRepositoryRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getMember(String id) {
        log.info("Getting the member with given id:" + id);
        return userRepository.findById(id).orElse(null);
    }

    public User saveMember(User user) {
        User userToSave;
        try {
            userToSave = userRepository.save(user);
            return userToSave;
        } catch (Exception e) {
            log.error("An error occurred during product saving:" + e.getMessage());
        }
        return new User();
    }

    public User updateMember(User userToUpdate, String id) {
        User foundUser = userRepository.findById(id).orElse(null);
        try {
            foundUser.setUsername(userToUpdate.getUsername());
            return userRepository.save(foundUser);
        } catch (Exception e) {
            log.error("An error occurred during update of product" + e.getMessage());
        }
        return userToUpdate;
    }

    public void deleteMember(String id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            log.error("An error occurred during deleting of product:" + e.getMessage());
        }
    }
}
