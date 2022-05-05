package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TestKafkaConsumer {

    @Autowired
    TestKafkaProducer producer;

    @KafkaListener(topics = "Madhukar", groupId = "foo")
    public void listenGroupFoo(String message) {
        if (message.contains("Retry")) {
            producer.sendMessage("Madhukar-retry", message);
        }
        System.out.println("Received Message in group foo: " + message);
    }

    @KafkaListener(topics = "Madhukar-retry", groupId = "foo")
    public void listenRetryGroupFoo(String message) {
        System.out.println("Received Message in group retry: " + message);
        if (message.contains("dlq")) {
            System.out.println("couter is " + message.substring(message.length() - 1));
            int counter = Integer.parseInt(message.substring(message.length() - 1));
            if (counter > 3) {
                producer.sendMessage("Madhukar-DLQ", message);
            } else {
                counter = counter+1;
                producer.sendMessage("Madhukar-retry", message.substring(0, message.length() - 1) + counter);
            }
        }
    }
}
