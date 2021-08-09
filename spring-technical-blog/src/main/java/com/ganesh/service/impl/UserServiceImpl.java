package com.ganesh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.model.User;
import com.ganesh.repository.UserRepository;
import com.ganesh.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(User user) {
		User existingUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if (existingUser != null) {
			return existingUser;
		} else {
			return null;
		}
	}

	@Override
	public void registerUser(User newUser) {
		userRepository.save(newUser);
	}

}
