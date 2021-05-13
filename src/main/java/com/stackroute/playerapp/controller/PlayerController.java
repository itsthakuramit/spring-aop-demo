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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.playerapp.model.Player;
import com.stackroute.playerapp.service.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@GetMapping("/")
	public String homepage() {
		return "Welcome to REST API";
	}
	
	@GetMapping("/getAllPlayers")
	public ResponseEntity<?> getAllPlayers(HttpSession httpSession) {
		ResponseEntity<?> response = null;
		String loggedInUser = (String) httpSession.getAttribute("loggedInUser");
		if(loggedInUser == null) {
			response = new ResponseEntity<String>("User is not logged in",HttpStatus.UNAUTHORIZED);
			return response;
		}
		System.out.println(loggedInUser);
		if(loggedInUser.equals("admin")) {
			List<Player> playerlist = playerService.getAllPlayers();
			response = new ResponseEntity<>(playerlist,HttpStatus.OK);
		}else {
			response = new ResponseEntity<String>("User is not authorized to perform this action",HttpStatus.UNAUTHORIZED);
		}
		return response;		
	}

	@PostMapping(value = "/addPlayer")
	public ResponseEntity<Player> addPlayer(@RequestBody Player newPlayer) {
	
		ResponseEntity<Player> response = null;
		Player addedPlayer = playerService.addPlayer(newPlayer);
		response = new ResponseEntity<>(addedPlayer,HttpStatus.CREATED);
		return response;
	}

	@DeleteMapping("/deletePlayer/{playerid}")
	public ResponseEntity<Player> deletePlayer(@PathVariable String playerid) {

		ResponseEntity<Player> response = null;
		Player deletedPlayer = playerService.deletePlayer(Integer.parseInt(playerid));
		response = new ResponseEntity<>(deletedPlayer,HttpStatus.OK);
		return response;	
		
	}

	@RequestMapping(value = "/getPlayer/{playerid}", method = RequestMethod.GET)
	public String getPlayerInfo(Model model, @PathVariable("playerid") String playerid) {
		Player player = playerService.getPlayerById(Integer.parseInt(playerid));
		
		return null;
	}

	
	

}
