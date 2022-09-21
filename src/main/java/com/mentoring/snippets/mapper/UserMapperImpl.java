package com.mentoring.snippets.mapper;

import com.mentoring.snippets.dto.UserDto;
import com.mentoring.snippets.model.User;

public class UserMapperImpl implements UserMapper {
    @Override
    public UserDto userDto(User user) {
        return userToUserDto(user);
    }

    public UserDto userToUserDto(User user) {
        if(user == null) {
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEnabled(user.getEnabled());

        return userDto;
    }
}
