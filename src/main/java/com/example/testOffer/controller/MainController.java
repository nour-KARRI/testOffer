package com.example.testOffer.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.testOffer.model.User;
import com.example.testOffer.repositories.UserRepositories;

@Controller
public class MainController {

	@Autowired
	private UserRepositories userRepositories;

	@GetMapping("/addUser")
	public String userForm(Model model) {
		var user = new User();
		model.addAttribute("user", user);
		return "register_form";
	}

	@PostMapping("/addUser")
	public String addUser(@Valid @ModelAttribute("user") @RequestBody User user, BindingResult result, ModelMap model,
			@RequestParam(value = "profession", defaultValue = "defaultValue") String profession) {

		userRepositories.deleteAll();

		/*
		 * Find user by email,
		 */

		var userExists = userRepositories.findByEmail(user.getEmail());
		/*
		 * Show error in the email input, if email exist already
		 */

		if (userExists != null) {
			result.rejectValue("email", "error.user", "There is already a user registered with the email provided");
		}
		if (!result.hasErrors()) {

			/*
			 * set the value of the not mandatory field, if null
			 */

			user.setProfession(profession);
			/*
			 * Save user
			 */
			User userDB = userRepositories.save(user);

			/*
			 * Return success Message
			 */
			model.addAttribute("successMessage", "User has been registered successfully");

			/*
			 * Render registered User
			 */
			model.addAttribute("userdb", userDB);

			/*
			 * Reset all the submission form
			 */
			model.addAttribute("user", new User());
		}
		return "register_form";

	}

}
