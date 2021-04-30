package com.example.testOffer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.testOffer.repositories.UserRepositories;

@Controller
public class MainController {

	@Autowired
	private UserRepositories userRepositories;

	@GetMapping("/register")
	public String getRegister(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register_form";
	}

	@GetMapping("/register/{email}")
	public User getUser(String email) {
		User user = userRepositories.findByEmail(email);
		return user;
	}

	@PostMapping("register")
	public String addUser(@Valid @ModelAttribute("user") @RequestBody User user, BindingResult result) {

		userRepositories.deleteAll();
		if (!result.hasErrors()) {
			userRepositories.save(user);
			return "register_success";
		}
		return "register_form";

	}
}
