package com.example.testOffer;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	@GetMapping("/register")
	public String getUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "register_form";
	}

	@PostMapping("register")
	public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "register_form";
		} else {

			return "register_success";
		}

	}
}
