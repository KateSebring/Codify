package com.codify.backend.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codify.backend.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	boolean existsById(int id); // check if user exists
	
	Optional<User> findById(int id); // attempt to find user
}