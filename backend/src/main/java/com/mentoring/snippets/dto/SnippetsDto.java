package com.mentoring.snippets.dto;

import lombok.Data;

@Data
public class SnippetsDto {
    private String id;
    private String text;
    private String category;
    private String language;
    private String username;
}
