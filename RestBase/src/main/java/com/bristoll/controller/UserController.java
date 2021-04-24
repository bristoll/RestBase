package com.bristoll.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bristoll.entity.User;
import com.bristoll.iservice.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAllUsers() {
		return new ResponseEntity<List<User>>(userService.findAllUsers(),HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id) {
		Optional<User> userOp = userService.findUserById(id);

		return ResponseEntity.of(userOp); // ok if present, not found if not

	}

	@PostMapping
	public ResponseEntity<User> saveUser(@Validated @RequestBody User user) {
		userService.saveUser(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable(value = "id") long id, @RequestParam("name") String name) {

		Optional<User> userOp = userService.updateUserById(id, name);
		return ResponseEntity.of(userOp); // ok if present, not found if not
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable(value = "id") long id){
		
		Optional<User> userOp = userService.findUserById(id);
		if (userOp.isPresent()) {
			userService.deleteUserById(id);
		}
		
		return ResponseEntity.of(userOp);
		
	}
}
