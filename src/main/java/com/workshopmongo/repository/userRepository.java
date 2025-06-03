package com.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workshopmongo.domain.User;

@Repository
public interface userRepository extends MongoRepository<User, String> {

}
