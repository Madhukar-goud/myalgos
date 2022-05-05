package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class TestKafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //Configure this
    private String topicName = "Madhukar";
    private String retryTopicName = "Madhukar-Retry";
    private String dlqTopicName = "Madhukar-DLQ";

    public void sendMessage(String topic, String message) {

        ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(topic, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                sendMessage(retryTopicName, message);
            }
        });
    }
}
