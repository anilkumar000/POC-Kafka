package com.stackroute.kafkaproducer.config;

import static com.ibm.common.activitystreams.Makers.activity;

import com.ibm.common.activitystreams.Activity;
//import com.stackroute.kafkaproducer.ProducerController;
import  org.apache.kafka.common.serialization.StringSerializer;
//import com.stackroute.kafkaproducer.ProducerController;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import com.stackroute.kafkaproducer.streams.StreamsTest;

import java.util.HashMap;
import java.util.Map;
@EnableKafka
@Configuration
@EnableBinding(StreamsTest.class)
public class KafkaProducerConfig {
    @Bean
    public ProducerFactory<Object,String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }
    @Bean
    public KafkaTemplate<Object, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
