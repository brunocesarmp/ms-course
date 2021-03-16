package dev.brunocesar.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.brunocesar.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
