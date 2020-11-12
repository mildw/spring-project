package com.mildw.minsu;

import com.mildw.minsu.controller.jwtAuth.rqrs.JwtAuthRq;
import com.mildw.minsu.dao.UserRepository;
import com.mildw.minsu.model.User;
import com.mildw.minsu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mildw.minsu.config", "com.mildw"})
@RequiredArgsConstructor
public class MinsuApplication extends SpringBootServletInitializer {

	private final UserService userService;


	public static void main(String[] args) {
		SpringApplication.run(MinsuApplication.class, args);
		}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new User("alstn428@naver.com", "1233ee","minsu"));

			for (User user : repository.findAll()) {
				System.out.println(user.toString());
				System.out.println(userService.createToken(new JwtAuthRq("alstn428@naver.com", "1233ee")));
			}


			// fetch an individual customer by ID
			User userEntity = repository.findById(1L).orElseGet(null);
			System.out.println("Customer found with findById(1L):");
			System.out.println("--------------------------------");
			System.out.println(userEntity.toString());
			System.out.println("");
		};
	}
}
