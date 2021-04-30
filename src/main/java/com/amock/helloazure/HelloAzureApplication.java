package com.amock.helloazure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class HelloAzureApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloAzureApplication.class, args);
	}

	@Controller
	class WebController {
		
		@GetMapping
		public String home(){
			return "index";
		}
	}
	
	@RestController
	class WebhookController
	{
		Logger logger = LoggerFactory.getLogger(WebhookController.class);
		@PostMapping("/webhook")
		public String webhook(@RequestBody String event)
		{
			logger.info("event {}",event);
			return "1";
		}
	}
}
