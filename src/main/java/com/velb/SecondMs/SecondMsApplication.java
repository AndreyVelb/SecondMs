package com.velb.SecondMs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SecondMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondMsApplication.class, args);
	}

}
