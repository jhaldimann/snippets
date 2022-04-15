package com.mentoring.snippets.repository;

import com.mentoring.snippets.model.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SnippetRepository extends JpaRepository<Snippet, String> {
    List<Snippet> findByUserid(String id);
}
