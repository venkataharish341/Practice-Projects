package com.learn2earn.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.learn2earn.todo.services.EmailService;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties // Application understands there are encrypted passwords.
@EnableResourceServer // This makes it resource server
@EnableGlobalMethodSecurity(prePostEnabled=true) // This enables to add security at method level. 
public class TodoApplication implements CommandLineRunner {

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Dude..");

		//emailService.sendMail("vharishtavva@gmail.com", "Good", "Good email body.");
	}

}
