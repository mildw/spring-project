package com.mildw.minsu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinsuApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinsuApplication.class, args);
		}

	/*@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new UserEntity("JackBauer"));
			repository.save(new UserEntity("ChloeO'Brian"));
			repository.save(new UserEntity("KimBauer"));
			repository.save(new UserEntity("DavidPalmer"));
			repository.save(new UserEntity("MichelleDessler"));

			// fetch all customers

			for (UserEntity userEntity : repository.findAll()) {
				System.out.println(userEntity.toString());
			}

			// fetch an individual customer by ID
			UserEntity userEntity = repository.findById(1L).orElseGet(null);
			System.out.println("Customer found with findById(1L):");
			System.out.println("--------------------------------");
			System.out.println(userEntity.toString());
			System.out.println("");
		};
	}*/
}
