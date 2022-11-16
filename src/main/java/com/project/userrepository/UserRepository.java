package com.project.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("Select u from User u Where u.email=?1")
	User findByEmail(String email);
}
