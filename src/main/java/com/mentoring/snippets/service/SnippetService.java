package com.mentoring.snippets.service;

import com.mentoring.snippets.model.Snippet;
import com.mentoring.snippets.repository.SnippetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnippetService {

    private Logger LOG = LoggerFactory.getLogger(SnippetService.class);

    private SnippetRepository snippetRepository;

    @Autowired
    public void setSnippetRepository(SnippetRepository snippetRepository) {
        this.snippetRepository = snippetRepository;
    }

    public Snippet getSnippet(String id) {
        LOG.info("Getting the snippet with given id:" + id);
        return snippetRepository.findById(id).orElse(null);
    }

    public Snippet saveSnippet(Snippet snippet) {
        Snippet snippetToSave;
        try {
            snippetToSave = snippetRepository.save(snippet);
            return snippetToSave;
        } catch (Exception e) {
            LOG.error("An error occurred during product saving:" + e.getMessage());
        }
        return new Snippet();
    }

    public Snippet updateSnippet(Snippet snippetToUpdate, String id) {
        Snippet foundSnippet = snippetRepository.findById(id).orElse(null);
        try {
            foundSnippet.setText(snippetToUpdate.getText());
            foundSnippet.setCategory(snippetToUpdate.getCategory());
            foundSnippet.setLanguage(snippetToUpdate.getLanguage());
            return snippetRepository.save(foundSnippet);
        } catch (Exception e) {
            LOG.error("An error pccurred during update of product" + e.getMessage());
        }
        return snippetToUpdate;
    }

    public void deleteSnippet(String id) {
        try {
            snippetRepository.deleteById(id);
        } catch (Exception e) {
            LOG.error("An error occurred during deleting of product:" + e.getMessage());
        }
    }
}
