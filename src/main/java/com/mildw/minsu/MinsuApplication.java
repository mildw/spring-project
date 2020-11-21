package com.mildw.minsu;

import com.mildw.minsu.dao.AccountRepository;
import com.mildw.minsu.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mildw.minsu.config", "com.mildw"})
public class MinsuApplication extends SpringBootServletInitializer {

	@Autowired
	public PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(MinsuApplication.class, args);
		}

	@Bean
	public CommandLineRunner demo(AccountRepository repository) {
		return (args) -> {
			// save a few customers
			Account account = new Account();
			account.setUsername("kms0428");
			account.setPassword(passwordEncoder.encode("1233"));
			account.setName("minsu");
			repository.save(account);

			for (Account user : repository.findAll()) {
				System.out.println(user.toString());
			}


			// fetch an individual customer by ID
			Account accountEntity = repository.findById(1L).orElseGet(null);
			System.out.println("Customer found with findById(1L):");
			System.out.println("--------------------------------");
			System.out.println(accountEntity.toString());
			System.out.println("");
		};
	}
}
