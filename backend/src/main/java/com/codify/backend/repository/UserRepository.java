package com.codify.backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codify.backend.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsById(int id); // check if user exists
	
	Optional<User> findById(int id); // attempt to find user
}