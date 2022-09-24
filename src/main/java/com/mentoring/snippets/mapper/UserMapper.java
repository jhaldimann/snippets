package com.mentoring.snippets.mapper;

import com.mentoring.snippets.dto.UserDto;
import com.mentoring.snippets.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "enabled", target = "enabled")
    UserDto userDto(User user);
}
