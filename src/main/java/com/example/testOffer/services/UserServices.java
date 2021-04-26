package com.example.testOffer.services;

import java.util.List;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.testOffer.models.User;
import com.example.testOffer.repositories.UserRepositories;

public abstract class UserServices implements UserRepositories{
	
	@Autowired
	private UserRepositories userRepositories;
	
	
	public void saveUser(User user) {
		
		userRepositories.save(user);
	}
	
	
	public User loadUserByUser(String firstName) throws NameNotFoundException{
		
		User user = userRepositories.findByfirstName(firstName);
		
		if (user!= null) {
			return user;
		} else {
			throw new NameNotFoundException("user not Found");
		}
		
		
	}

}
