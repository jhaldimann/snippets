package com.mentoring.snippets.dto;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String username;
    private String password;
    private int enabled;
}
