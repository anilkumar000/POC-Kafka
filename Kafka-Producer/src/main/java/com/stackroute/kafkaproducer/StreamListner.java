package com.stackroute.kafkaproducer;

import com.stackroute.kafkaproducer.streams.StreamsTest;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component

public class StreamListner {

        @StreamListener(StreamsTest.INPUT)
        public void handleGreetings(@Payload Greetings greetings) {
            System.out.println("Received greetings: {}" +greetings);
        }
    }

