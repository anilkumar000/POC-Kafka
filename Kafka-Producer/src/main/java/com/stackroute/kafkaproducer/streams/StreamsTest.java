package com.stackroute.kafkaproducer.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamsTest {
    String INPUT = "TextLinesTopic";
    String OUTPUT = "WordsWithCountsTopic";
    @Input(INPUT)
    SubscribableChannel inboundGreetings();
    @Output(OUTPUT)
    MessageChannel outboundGreetings();
}
