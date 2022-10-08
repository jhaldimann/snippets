package com.mentoring.snippets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class ProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    public ProducerService() {}

    public void createManualProducer(String message) {
        String eventKey = "Saved";
        raiseEvent(eventKey, message);
    }

    private void raiseEvent(String eventKey, String message) {
        try {
            this.kafkaTemplate.sendDefault(eventKey, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
