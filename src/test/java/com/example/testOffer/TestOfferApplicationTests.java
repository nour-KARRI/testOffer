package com.example.testOffer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.testOffer.repositories.UserRepositories;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestOfferApplicationTests {

	@Autowired
	private MainController controller;

	@MockBean
	private UserRepositories repository;

	@Test
	public void getUserbyEmailTest() {
		String email = "daniel@gmail.com";
		when(repository.findByEmail(email))
				.thenReturn(new User("daniel", "daniel@gmail.com", 36, "france", "designer"));

		assertEquals(email, repository.findByEmail(email).getEmail());
	}

	@Test
	public void saveUserTest() {
		User user = new User("camille", "camille2@gmail.com", 32, "france", "master");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, repository.save(user));

	}

}
