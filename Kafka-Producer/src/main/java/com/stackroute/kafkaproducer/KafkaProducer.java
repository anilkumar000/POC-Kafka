package com.stackroute.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Service
@RestController
@RequestMapping("Kafka")
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<Object, ProducerController> kafkaTemplate;
//    @GetMapping("/publish/data")
//    public String sendMessage() {
//        kafkaTemplate.send("test-kafka", "AnilKumar");
//        return "published successfully";
//    }

//
    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String message){

        kafkaTemplate.send("test-kafka",new ProducerController("anil",22));

        return "published succefully";
    }
}
