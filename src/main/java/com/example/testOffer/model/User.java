package com.example.testOffer.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "users")
public class User {

	@Id
	private String id;
	@Size(min = 3, max = 50)
	private String name;

	@Email(message = "Please enter a valid e-mail address")
	private String email;

	@Min(value = 19, message = "To register, you must be over 18 years old ")
	private int age;

	@Pattern(regexp = "^France$|^france$", message = "only adults live in France can create an account")
	private String country;

	private String profession;

	/*
	 * default constructor
	 */
	public User() {
	}

	/*
	 * constructor
	 */

	public User(String name, String email, int age, String country, String profession) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.country = country;
		this.profession = profession;
	}

}
