package com.zt.vehiclesmailingservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class VehiclesMailingServiceApplication {
	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(VehiclesMailingServiceApplication.class, args);
	}
	@RabbitListener(queues = "EkmtVehiclesQueue")

		public void listenAndSend (String message){
		System.out.println(message);
		emailSenderService.sendSimpleMessage("zlatko.talevski7@gmail.com", "Известување", message);
	}

}
