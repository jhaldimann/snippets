package com.mentoring.snippets.repository;

import com.mentoring.snippets.model.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnippetRepository extends JpaRepository<Snippet, String> {
    Snippet findByCategory(String category);
    Long deleteOneById(String id);
}
