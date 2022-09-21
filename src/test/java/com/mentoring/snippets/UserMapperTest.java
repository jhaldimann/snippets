package com.mentoring.snippets;

import com.mentoring.snippets.dto.UserDto;
import com.mentoring.snippets.mapper.UserMapper;
import com.mentoring.snippets.mapper.UserMapperImpl;
import com.mentoring.snippets.model.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mapstruct.factory.Mappers;

public class UserMapperTest {
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void testMapping() {
        UserDto userDto = userMapper.userDto(new User("1","Tester", "Password", 1));
        Assertions.assertNotNull(userDto);
        Assertions.assertEquals("1", userDto.getId());
        Assertions.assertEquals("Tester", userDto.getUsername());
        Assertions.assertEquals("Password", userDto.getPassword());
        Assertions.assertEquals(1, userDto.getEnabled());
    }

    @Test
    public void testNullMapping() {
        UserDto nullUserDto = userMapper.userDto(null);
        Assertions.assertNull(nullUserDto);
    }

    @Test
    public void testEmptyUser() {
        UserDto emptyUserDto = userMapper.userDto(new User());
        Assertions.assertNotNull(emptyUserDto);
        Assertions.assertNull(emptyUserDto.getUsername());
        Assertions.assertNull(emptyUserDto.getPassword());
        Assertions.assertEquals(0, emptyUserDto.getEnabled());
    }
}
