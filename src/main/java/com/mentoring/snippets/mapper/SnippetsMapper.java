package com.mentoring.snippets.mapper;

import com.mentoring.snippets.dto.SnippetsDto;
import com.mentoring.snippets.model.Snippet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SnippetsMapper {
    SnippetsDto snippetsDto (Snippet snippet);
}
