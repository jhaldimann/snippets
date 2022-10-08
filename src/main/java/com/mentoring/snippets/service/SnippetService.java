package com.mentoring.snippets.service;

import com.mentoring.snippets.model.Snippet;
import com.mentoring.snippets.repository.SnippetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SnippetService {

    private SnippetRepository snippetRepository;
    private final ProducerService producerService;

    @Autowired
    public SnippetService(ProducerService producerService) {
        this.producerService = producerService;
    }

    @Autowired
    public void setSnippetRepository(SnippetRepository snippetRepository) {
        this.snippetRepository = snippetRepository;
    }

    public List<Snippet> getSnippets() {
        log.info("Return all snippets");
        return snippetRepository.findAll();
    }

    public List<Snippet> getSnippetsByUsername(String username) {
        return snippetRepository.findByUsername(username);
    }

    public Snippet saveSnippet(Snippet snippet) {
        log.info("---> Start Snippet saving <---");
        Snippet snippetToSave;
        try {
            snippetToSave = snippetRepository.save(snippet);
            producerService.createManualProducer("[Snippet Saved] " + snippetToSave);
            log.info("Snippet saved");
            return snippetToSave;
        } catch (Exception e) {
            producerService.createManualProducer("[Error] An error occurred during product saving:" + e.getMessage());
            log.error("An error occurred during product saving:" + e.getMessage());
        }
        return new Snippet();
    }

    public Snippet updateSnippet(Snippet snippet) {
        log.info("---> Start Snippet saving <---");
        Snippet foundSnippet = snippetRepository.findById(snippet.getId()).get();
        foundSnippet.setUsername(snippet.getUsername());
        foundSnippet.setCategory(snippet.getCategory());
        foundSnippet.setLanguage(snippet.getLanguage());
        foundSnippet.setText(snippet.getText());
        try {
            Snippet updatedSnippet = snippetRepository.save(foundSnippet);
            producerService.createManualProducer("[Snippet Updated] " + updatedSnippet);
        } catch (Exception e) {
            log.error("An error occurred during update of snippet" + e.getMessage());
        }
        return snippet;
    }

    public void deleteSnippet(String id) {
        try {
            snippetRepository.deleteById(id);
            producerService.createManualProducer("[Snippet Deleted] " + "Snippet " + id + " has been removed");
            log.info("Snippet" + id + "has been removed");
        } catch (Exception e) {
            log.error("An error occurred during deleting of product:" + e.getMessage());
        }
    }
}
