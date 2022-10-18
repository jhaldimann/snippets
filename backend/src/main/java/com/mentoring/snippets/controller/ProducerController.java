package com.mentoring.snippets.controller;

import com.mentoring.snippets.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final ProducerService producerService;

    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping(value="/create-teacher")
    public void createTeacherProducer() {
        producerService.createManualProducer("I am a test");
    }
}
