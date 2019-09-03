package com.stackroute.kafkaproducer.services;

import com.stackroute.kafkaproducer.Greetings;
import com.stackroute.kafkaproducer.streams.StreamsTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
@Service

public class StreamService {
    private final StreamsTest streamsTest;
    public StreamService(StreamsTest streamsTest) {
        this.streamsTest = streamsTest;
    }
    public void sendGreeting(final String greetings) {
        System.out.println("Sending greetings {}"+greetings);
        MessageChannel messageChannel = streamsTest.outboundGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
        System.out.println(messageChannel);
    }
}
