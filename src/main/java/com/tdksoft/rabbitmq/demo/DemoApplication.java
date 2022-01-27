package com.tdksoft.rabbitmq.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if(rabbitTemplate == null){
			throw new Exception("Dependency injection filed");
		}
		rabbitTemplate.convertAndSend("Hello from our first message");
	}
}
