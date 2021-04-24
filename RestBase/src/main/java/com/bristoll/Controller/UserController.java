package com.bristoll.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bristoll.Entities.User;
import com.bristoll.Repositories.UserRepository;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping
	public List<User> findAllUsers(){
		return (List<User>) userRepo.findAll();
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findUserById(@PathVariable(value= "id") long id){
		Optional<User> userOp = userRepo.findById(id);
			
			return ResponseEntity.of(userOp); //ok if present, not found ir not
		
		
	}
	
	@PostMapping
	public User saveUser(@Validated @RequestBody User user) {
		userRepo.save(user);
		return user;
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable(value= "id") long id, @RequestParam("name") String name){
		
		Optional<User> userOp = userRepo.findById(id);
		if (userOp.isPresent()) {
			User user =userOp.get();
			user.setName(name);
			userRepo.save(user);
			return ResponseEntity.ok(user);
		}else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
}
