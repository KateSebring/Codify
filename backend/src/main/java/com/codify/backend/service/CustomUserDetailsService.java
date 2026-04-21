package com.codify.backend.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codify.backend.model.User;
import com.codify.backend.model.UserPrincipal;
import com.codify.backend.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	private final UserRepository repo;
	
	public CustomUserDetailsService(UserRepository userRepository) {
		this.repo = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username)
				.orElseThrow(() -> 
				new UsernameNotFoundException("User not found."));
		
		return new UserPrincipal(user);
	}

}
