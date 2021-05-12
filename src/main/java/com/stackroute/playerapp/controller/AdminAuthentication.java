package com.stackroute.playerapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.playerapp.model.Player;
import com.stackroute.playerapp.model.User;
import com.stackroute.playerapp.service.PlayerService;
import com.stackroute.playerapp.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class AdminAuthentication {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user){
		User newuser = userService.addUser(user);
		if(newuser !=null) {
			return new ResponseEntity<User>(newuser, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("User registration unsuccessful",HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User user, HttpSession httpsession){
		User existinguser = userService.validate(user.getUsername(), user.getPassword());
		if(existinguser !=null) {
			httpsession.setAttribute("loggedInUser", existinguser.getUsername());
			return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("User authentication failed",HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PutMapping("/logout")
	public ResponseEntity<String> logout(HttpSession httpsession){
		User existinguser = userService.getUserByUsername((String)httpsession.getAttribute("loggedInUser"));
		if(existinguser !=null) {
			httpsession.invalidate();
			return new ResponseEntity<>("User logged out", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("User logout has issues",HttpStatus.CONFLICT);
		}
	}
	


}
