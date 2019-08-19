package com.stackroute.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication  {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}
}
