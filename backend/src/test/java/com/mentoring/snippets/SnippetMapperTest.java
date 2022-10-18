package com.mentoring.snippets;

import com.mentoring.snippets.dto.SnippetsDto;
import com.mentoring.snippets.mapper.SnippetsMapper;
import com.mentoring.snippets.model.Snippet;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mapstruct.factory.Mappers;

public class SnippetMapperTest {
    private final SnippetsMapper snippetMapper = Mappers.getMapper(SnippetsMapper.class);

    @Test
    public void testMapping() {
        SnippetsDto snippetDto = snippetMapper.snippetsDto(new Snippet("1","My Code", "Code", "Java", "Tester"));
        Assertions.assertNotNull(snippetDto);
        Assertions.assertEquals("1", snippetDto.getId());
        Assertions.assertEquals("My Code", snippetDto.getText());
        Assertions.assertEquals("Code", snippetDto.getCategory());
        Assertions.assertEquals("Java", snippetDto.getLanguage());
        Assertions.assertEquals("Tester", snippetDto.getUsername());
    }

    @Test
    public void testNullMapping() {
        SnippetsDto nullSnippetDto = snippetMapper.snippetsDto(null);
        Assertions.assertNull(nullSnippetDto);
    }

    @Test
    public void testEmptySnippet() {
        SnippetsDto emptySnippetDto = snippetMapper.snippetsDto(new Snippet());
        Assertions.assertNotNull(emptySnippetDto);
        Assertions.assertNull(emptySnippetDto.getId());
        Assertions.assertNull(emptySnippetDto.getText());
        Assertions.assertNull(emptySnippetDto.getCategory());
        Assertions.assertNull(emptySnippetDto.getLanguage());
        Assertions.assertNull(emptySnippetDto.getUsername());
    }
}
