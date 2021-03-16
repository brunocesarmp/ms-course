package dev.brunocesar.hruser.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.brunocesar.hruser.entities.User;
import dev.brunocesar.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private final UserRepository repository;

	public UserResource(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") Long id) {
		var user = repository.findById(id).get();
		return ResponseEntity.ok(user);
	}

	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam("email") String email) {
		var user = repository.findByEmail(email);
		return ResponseEntity.ok(user);
	}

}