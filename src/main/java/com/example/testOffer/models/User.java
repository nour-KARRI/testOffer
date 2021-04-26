package com.example.testOffer.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="user")
public class User {

	
	
	@Field
	private String firstName;
	@Field
	private String lastName;
	@Field
	private int age;
	@Field
	private String status;
	
	
	
	public User() {
		
	}



	public User(String firstName, String lastName, int age, String status) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.status = status;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", status="
				+ status + "]";
	}
	
	
	
}
