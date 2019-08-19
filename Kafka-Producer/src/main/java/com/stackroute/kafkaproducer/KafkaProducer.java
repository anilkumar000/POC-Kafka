package com.stackroute.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Service
@RestController
@RequestMapping("Kafka")
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<Object, String> kafkaTemplate;
    @GetMapping("/publish/data")
    public String sendMessage() {
        kafkaTemplate.send("test-kafka", "AnilKumar");
        return "published successfully";
    }

////
//    @GetMapping("/publish/{name}")
//    public String post(@PathVariable("name") final String message){
//
//        kafkaTemplate.send("mytopic",new ProducerController("jyothi",22));
//
//        return "published succefully";
//    }

}
