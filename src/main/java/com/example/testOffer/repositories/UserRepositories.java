package com.example.testOffer.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.testOffer.models.User;


@Repository
public interface UserRepositories extends MongoRepository<User, Integer>{

}
