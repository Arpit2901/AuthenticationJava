package com.project.customuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.entity.User;
import com.project.userrepository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repo.findByEmail(email);
		if(user ==null) {
			throw new UsernameNotFoundException("User not Found");
		}
		System.out.println("foundddd...");
		return (UserDetails) user;
	}

}
