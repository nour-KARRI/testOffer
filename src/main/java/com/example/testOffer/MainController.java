package com.example.testOffer;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	Logger logger = LoggerFactory.getLogger(User.class);

	@GetMapping("/register")
	public String getUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		logger.trace("user retrieve");
		return "register_form";
	}

	@PostMapping("register")
	public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

		System.out.println("bindingResult: " + bindingResult);
		if (bindingResult.hasErrors()) {
			return "register_form";
		} else {
			logger.trace("user secceeded");
			return "register_success";
		}

	}
}
