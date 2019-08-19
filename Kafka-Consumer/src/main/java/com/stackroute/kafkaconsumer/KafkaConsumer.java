package com.stackroute.kafkaconsumer;


import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
public class KafkaConsumer {
    @KafkaListener(topics="test-kafka")
    public void listen(String message) {
        System.out.println("Received Messasge in group - group-id: " + message);
    }
}
