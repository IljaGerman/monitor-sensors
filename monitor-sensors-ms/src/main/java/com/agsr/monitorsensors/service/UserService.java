package com.agsr.monitorsensors.service;

import com.agsr.monitorsensors.domain.User;
import com.agsr.monitorsensors.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User findByName(String name) {
		return userRepository.findByName(name).orElseThrow(() -> new RuntimeException("No such user"));
	}

}
