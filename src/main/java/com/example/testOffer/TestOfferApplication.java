package com.example.testOffer;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.testOffer.models.User;
import com.example.testOffer.repositories.UserRepositories;
@Configuration
@SpringBootApplication
public class TestOfferApplication implements CommandLineRunner{

	@Autowired
	private UserRepositories userRepositories;
	
	

	public static void main(String[] args) {
		SpringApplication.run(TestOfferApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	/*	if (userRepositories.findAll().isEmpty()) {

			userRepositories.save(new User("nour", "karri", 30, "developper"));
			
		}*/
		
		//userRepositories.deleteAll();
		
		User user2= new User("daniel", "devi", 25, "manager");
		
		List<User> tab= Arrays.asList(user2);
		userRepositories.insert(tab);
		
		for (User user1 : userRepositories.findAll()) {
			
			System.out.println(user1);
			
		}
		
		
	}

}
