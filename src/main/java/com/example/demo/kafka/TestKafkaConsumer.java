package com.example.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TestKafkaConsumer {

    @KafkaListener(topics = "Madhukar", groupId = "foo")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
