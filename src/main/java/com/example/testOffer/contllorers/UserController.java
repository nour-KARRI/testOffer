package com.example.testOffer.contllorers;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.testOffer.models.User;
import com.example.testOffer.services.UserServices;

@Controller
public class UserController {

	@Autowired
	private UserServices userService;
	
	@RequestMapping(value="/postUser", method=RequestMethod.POST)
	public void addUser(User user) {
		
		userService.saveUser(user);
	}
	
	@GetMapping(value="/getUser")
	public User getUser(String firstName, BindingResult bindingResult) throws NameNotFoundException {
		User user= userService.loadUserByUser(firstName);
		if (user!= null) {
			return user;
		}
		else {
			throw new NameNotFoundException ("User not found with username:" + firstName);
		}
		
		
	}
	
}
