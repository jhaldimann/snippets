package com.mentoring.snippets.mapper;

import com.mentoring.snippets.dto.SnippetsDto;
import com.mentoring.snippets.model.Snippet;

public class SnippetsMapperImpl implements SnippetsMapper {
    @Override
    public SnippetsDto snippetsDto(Snippet snippet) {
        return snippetToSnippetsDto(snippet);
    }

    public SnippetsDto snippetToSnippetsDto(Snippet snippet) {
        if(snippet == null) {
            return null;
        }

        SnippetsDto snippetsDto = new SnippetsDto();
        snippetsDto.setId(snippet.getId());
        snippetsDto.setUsername(snippet.getUsername());
        snippetsDto.setText(snippet.getText());
        snippetsDto.setLanguage(snippet.getLanguage());
        snippetsDto.setCategory(snippet.getCategory());

        return snippetsDto;
    }
}
