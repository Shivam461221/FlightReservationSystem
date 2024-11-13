package com.shivam.flightreservationapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.flightreservationapp.entities.LoginRequest;
import com.shivam.flightreservationapp.entities.LoginResponse;
import com.shivam.flightreservationapp.entities.User;
import com.shivam.flightreservationapp.services.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		userService.register(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		Optional<LoginResponse> loginResponse = userService.login(loginRequest.getUsername(),
				loginRequest.getPassword());

		if (loginResponse.isPresent()) {
			return ResponseEntity.ok(loginResponse.get());
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findUserById(@PathVariable Long id) {
		Optional<User> user = userService.findById(id);

		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
		Optional<User> updatedUserOpt = userService.updateUser(id, updatedUser);

		if (updatedUserOpt.isPresent()) {
			return ResponseEntity.ok("User updated successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}

}
