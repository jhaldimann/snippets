package com.mentoring.snippets.repository;

import com.mentoring.snippets.model.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnippetRepository extends JpaRepository<Snippet, String> {
}
