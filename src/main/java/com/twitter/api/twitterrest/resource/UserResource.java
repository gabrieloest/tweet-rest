package com.twitter.api.twitterrest.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.twitter.api.twitterrest.domain.User;
import com.twitter.api.twitterrest.exception.UserNotFoundException;
import com.twitter.api.twitterrest.repository.UserRepository;

@RestController
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		return user.get();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable int id) {

		Optional<User> userOptional = userRepository.findById(id);

		if (!userOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		user.setId(id);

		userRepository.save(user);

		return ResponseEntity.noContent().build();
	}
}
