package com.nubank;

import com.nubank.service.JsonStdinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NubankApplication implements CommandLineRunner {

	@Autowired
	private JsonStdinService jsonStdinService;

	public static void main(String[] args) {
		SpringApplication.run(NubankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jsonStdinService.processJsonInput();
	}
}