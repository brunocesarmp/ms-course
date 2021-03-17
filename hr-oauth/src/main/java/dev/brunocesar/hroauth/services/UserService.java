package dev.brunocesar.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.brunocesar.hroauth.entities.User;
import dev.brunocesar.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeignClient;

	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if (user == null) {
			log.warn("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		log.info("Email found: " + email);
		return user;
	}

}
