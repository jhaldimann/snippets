package com.mentoring.snippets.dto;

import lombok.Getter;
import lombok.Setter;

public class MessageDTO {

    @Getter @Setter
    private String message;
    @Getter @Setter
    private String type;

    public MessageDTO() {
    }
}