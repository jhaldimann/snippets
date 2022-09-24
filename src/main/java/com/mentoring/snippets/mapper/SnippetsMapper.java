package com.mentoring.snippets.mapper;

import com.mentoring.snippets.dto.SnippetsDto;
import com.mentoring.snippets.model.Snippet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SnippetsMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "text", target = "text")
    @Mapping(source = "language", target = "language")
    @Mapping(source = "category", target = "category")
    SnippetsDto snippetsDto (Snippet snippet);
}
