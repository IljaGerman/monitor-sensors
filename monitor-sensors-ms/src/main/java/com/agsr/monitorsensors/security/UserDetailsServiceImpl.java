package com.agsr.monitorsensors.security;

import com.agsr.monitorsensors.domain.User;
import com.agsr.monitorsensors.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByName(username);

		List<SimpleGrantedAuthority> authorities = Arrays.stream(user.getRole().split(", "))
			.map(SimpleGrantedAuthority::new)
			.toList();
		log.info(user.getName());
		return new org.springframework.security.core.userdetails.User(
			user.getName(), user.getPassword(), authorities
		);
	}

}
