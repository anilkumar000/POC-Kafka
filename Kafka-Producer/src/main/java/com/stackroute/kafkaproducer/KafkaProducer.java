package com.stackroute.kafkaproducer;

import com.stackroute.kafkaproducer.services.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

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

    private final StreamService streamService;
    public KafkaProducer(StreamService streamService) {
        this.streamService = streamService;
    }
    @GetMapping("/greetings/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void greetings(@PathVariable("name") String message) {
        Greetings greetings = Greetings.builder()
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();
        streamService.sendGreeting(greetings);
    }
}
