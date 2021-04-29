package com.example.testOffer;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	@Size(min = 3, max = 50)
	private String name;

	@Email(message = "Please enter a valid e-mail address")
	private String email;

	@Min(value = 19, message = "To register, you must be over 18 years old ")
	private int age;

	@Pattern(regexp = "^France|france", message = "only adults live in France can create an account")
	private String country;
	private String profession;

	public User() {

	}

	public User(String name, String email, int age, String country, String profession) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.country = country;
		this.profession = profession;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", age=" + age + ", country=" + country + ", profession="
				+ profession + "]";
	}

}
