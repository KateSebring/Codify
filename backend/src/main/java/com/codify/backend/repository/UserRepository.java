package com.codify.backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codify.backend.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {	
	Optional<User> findById(int id); // attempt to find user
	
	Optional<User> findByUsername(String username);
	
	Optional<User> findByEmail(String email);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);
}