package com.mentoring.snippets.mapper;

import com.mentoring.snippets.dto.UserDto;
import com.mentoring.snippets.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userDto(User user);
}
