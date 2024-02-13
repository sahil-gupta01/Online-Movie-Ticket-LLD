package com.bookMyShow.demo;

import com.bookMyShow.demo.controllers.UserController;
import com.bookMyShow.demo.dtos.UserSingUpRequestDto;
import com.bookMyShow.demo.models.User;
import com.bookMyShow.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private UserController userController;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserSingUpRequestDto request = new UserSingUpRequestDto();
		request.setEmail("SahilGupta@gmail.com");
		request.setName("Sahil");
		request.setPassword("Password");
		userController.signUp(request);

		//check for the successfully login
		System.out.println(userController.login("SahilGupta@gmail.com", "Password"));

	}
}
