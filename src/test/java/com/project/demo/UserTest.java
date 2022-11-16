package com.project.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.project.entity.User;
import com.project.userrepository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserTest {
	@Autowired
	private UserRepository repo;
	@Autowired
	private TestEntityManager ent;
	
	@Test
	public void testCreateUser() {
		User user =new User();
		user.setEmail("shyam@gmial.com");
		user.setPassword("shamt@2000");
		user.setFirstName("Shyam");
		user.setLastName("verma");
		User savedUser=repo.save(user);
		
		User existUser=ent.find(User.class,savedUser.getId());
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}
	@Test
	public void testFindUseryEmail() {
		String email="varu1n@gmail.com";
		User user=repo.findByEmail(email);
		assertThat(user).isNotNull();
	}
}
