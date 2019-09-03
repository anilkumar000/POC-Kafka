package com.stackroute.kafkaproducer;

import com.ibm.common.activitystreams.ASObject;
import com.ibm.common.activitystreams.Activity;
import com.ibm.common.activitystreams.Makers;
import com.stackroute.kafkaproducer.services.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import static com.ibm.common.activitystreams.IO.makeDefaultPrettyPrint;
import static com.ibm.common.activitystreams.Makers.activity;
import static com.ibm.common.activitystreams.Makers.object;
//@Service
@RestController
@RequestMapping("Kafka")
public class KafkaProducer {


//    @Autowired
//    private KafkaTemplate<Object, String> kafkaTemplate;
//    @GetMapping("/publish/data")
//    public String sendMessage() {
//        kafkaTemplate.send("TextLinesTopic", "AnilKumar");
//        return "published successfully";
//    }

//
//    @GetMapping("/publish/{name}")
//    public String post(@PathVariable("name") final String message){
//
////        kafkaTemplate.send("test-kafka",new ProducerController("anil",22));
//
//        return "published succefully";
//    }

    private final StreamService streamService;

    public KafkaProducer(StreamService streamService) {
        this.streamService = streamService;
    }
//
    @GetMapping("/greetings/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void greetings(@PathVariable("name") String message) {
        Greetings greetings = Greetings.builder()
                .message(message.toUpperCase())
                .timestamp(System.currentTimeMillis())
                .build();
        streamService.sendGreeting(message);
    }
//
//
//    @GetMapping("/publish")
//    public Object postActivity(){
//        ASObject object = activity()
//                .verb("post")
//                .actor(
//                        object("person")
//                                .id("acct:joe@example.com")
//                                .displayName("Joe Smith")
//                )
//                .object(
//                        object("note")
//                                .id("http://example.net/posts/1")
//                                .title("This is the title"))
//                .get();
//        System.out.println(object);
//        Activity activity =
//                activity()
//                        .actor(object("person").id("acct:joe@example.org"))
//                        .object(object("note").content("my note"))
//                        .verb("post")
//                        .get();
////        kafkaTemplate.send("test-kafka",object);
//              return object;
//    }

}
