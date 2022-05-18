package com.mentoring.snippets.service;

import com.mentoring.snippets.model.Snippet;
import com.mentoring.snippets.repository.SnippetRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SnippetService {

    private SnippetRepository snippetRepository;

    @Autowired
    public void setSnippetRepository(SnippetRepository snippetRepository) {
        this.snippetRepository = snippetRepository;
    }

    public Snippet getSnippet(String id) {
        log.info("Getting the snippet with given id:" + id);
        return snippetRepository.findById(id).orElse(null);
    }

    public List<Snippet> getSnippets() {
        log.info("Return all snippets");
        return snippetRepository.findAll();
    }

    public List<Snippet> getSnippetsByUserId(String userid) {
        log.info("Return all snippets of user" + userid);
        return snippetRepository.findByUserid(userid);
    }

    public Snippet saveSnippet(Snippet snippet) {
        Snippet snippetToSave;
        try {
            snippetToSave = snippetRepository.save(snippet);
            log.info("Snippet saved");
            return snippetToSave;
        } catch (Exception e) {
            log.error("An error occurred during product saving:" + e.getMessage());
        }
        return new Snippet();
    }

    public Snippet updateSnippet(Snippet snippetToUpdate, String id) {
        Snippet foundSnippet = snippetRepository.findById(id).orElse(null);
        try {
            foundSnippet.setText(snippetToUpdate.getText());
            foundSnippet.setCategory(snippetToUpdate.getCategory());
            foundSnippet.setLanguage(snippetToUpdate.getLanguage());
            foundSnippet.setUserid(snippetToUpdate.getUserid());
            log.info("Snippet" + id + "was updated");
            return snippetRepository.save(foundSnippet);
        } catch (Exception e) {
            log.error("An error pccurred during update of product" + e.getMessage());
        }
        return snippetToUpdate;
    }

    public void deleteSnippet(String id) {
        try {
            snippetRepository.deleteById(id);
            log.info("Snippet" + id + "has been removed");
        } catch (Exception e) {
            log.error("An error occurred during deleting of product:" + e.getMessage());
        }
    }
}
