package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.User;
import com.project.userrepository.UserRepository;

@RestController
@CrossOrigin("*")
//@RequestMapping("/api/")
public class UserController {
	@Autowired
	private UserRepository repo;

	@GetMapping("")
	public String viewHome() {
		return "index";
	}
	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
	    return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}

	@GetMapping("/sign")
	public String signUp(Model model) {
		model.addAttribute("user", new User());
		return "signUp";
	}
	@PostMapping("/signup")
	public User addUser(@RequestBody User user) {
		System.out.println("in post query");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword=encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		User newUser=repo.save(user);
		return newUser;
	}   
	
	@PostMapping("/register")
	public String registration( User user) {
	
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword=encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		return "success";
	}
	@GetMapping("/list_users")
	public String listOfUsers(Model model) {
		List<User>listUsers=repo.findAll();
		model.addAttribute("listUsers",listUsers);
		System.out.println("list...."+listUsers);
		return "users";
	}
	@GetMapping("/userslist")
	public List<User> view(Model model) {
		System.out.println("workinggggg------------&*");
		List<User>listUsers=repo.findAll();
		model.addAttribute("listUsers",listUsers);
		System.out.println("list...."+listUsers);
		return listUsers;
	}
}
