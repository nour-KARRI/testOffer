package com.example.testOffer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

	@PostMapping("register")
	public String addUser(@Valid @ModelAttribute("user") @RequestBody User user, BindingResult result, ModelMap model) {

		// userRepositories.deleteAll();

		User userExists = userRepositories.findByEmail(user.getEmail());

		System.out.println("Get user from DB: " + userExists);

		if (userExists != null) {
			result.rejectValue("email", "error.user", "There is already a user registered with the email provided");
		}
		if (!result.hasErrors()) {
			userRepositories.save(user);
			model.addAttribute("successMessage", "User has been registered successfully");

		}
		return "register_form";

	}
}
