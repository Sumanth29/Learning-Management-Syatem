package com.lms.app;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import com.lms.app.entities.UserEntity;
import com.lms.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class AppApplication {
	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@PostConstruct
	public void initUsers() {
		List<UserEntity> users = Stream.of(
				new UserEntity( "admin", "1234","ROLE_ADMIN"),
				new UserEntity("user", "1234","ROLE_USER")).collect(Collectors.toList());

		repository.saveAll(users);
	}
}