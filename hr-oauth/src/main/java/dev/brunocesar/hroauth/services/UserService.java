package dev.brunocesar.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.brunocesar.hroauth.entities.User;
import dev.brunocesar.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeignClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(username).getBody();
		if (user == null) {
			log.warn("Email not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		log.info("Email found: " + username);
		return user;
	}

}
