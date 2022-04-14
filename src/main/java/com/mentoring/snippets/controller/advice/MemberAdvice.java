package com.mentoring.snippets.controller.advice;

import com.mentoring.snippets.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class MemberAdvice {
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDTO processNullPointerException(NullPointerException exception) {

        MessageDTO message = new MessageDTO();
        message.setMessage("Errors found in request, try again later: " + exception);
        message.setType("ERROR");
        return message;
    }
}
