package com.project.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword="varun@123";
		String encodedPassword= encoder.encode(rawPassword);
		System.out.println(encodedPassword);
	}

}
