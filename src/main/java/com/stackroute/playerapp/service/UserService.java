package com.stackroute.playerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.playerapp.model.User;
import com.stackroute.playerapp.repository.UserRepository;



@Service
public class UserService{


	UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	public User addUser(User User) {
		User addedUser = userRepository.addUser(User);
		return addedUser;
	}


	public User validate(String username, String password) {
		User user = userRepository.validate(username,password);
		System.out.println(user.getUsername());
		return user;
	}


	public User getUserByUsername(String username) {
		User user = userRepository.getUserByUsername(username);
		return user;
	}



	
}
