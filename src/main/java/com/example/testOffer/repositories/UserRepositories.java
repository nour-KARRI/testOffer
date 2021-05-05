package com.example.testOffer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.testOffer.model.User;

@Repository
public interface UserRepositories extends MongoRepository<User, String> {

	User findByEmail(String email);
}
