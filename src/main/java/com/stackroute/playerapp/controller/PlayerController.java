package com.stackroute.playerapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.playerapp.model.Player;
import com.stackroute.playerapp.service.PlayerService;

@Controller
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAllPlayers(Model model) {
		List<Player> playerlist = playerService.getAllPlayers();
		model.addAttribute("playerlist", playerlist);
		return "index";
	}

	@RequestMapping(value = "/addPlayer", method = RequestMethod.POST)
	public String addPlayer(Model model, HttpServletRequest req, HttpServletResponse res) {
	
		Player newPlayer = new Player();
		newPlayer.setPlayerid(req.getParameter("playerid"));
		newPlayer.setPlayername(req.getParameter("playername"));
		newPlayer.setCountry(req.getParameter("country"));
		newPlayer.setSports(req.getParameter("sports"));

		playerService.addPlayer(newPlayer);

		return "redirect:/";
	}

	@RequestMapping(value = "/deletePlayer", method = RequestMethod.GET)
	public String deletePlayer(@RequestParam String playerid) {

		playerService.deletePlayer(playerid);
		return "redirect:/";
	}

	@RequestMapping(value = "/getPlayer/{playerid}", method = RequestMethod.GET)
	public String getPlayerInfo(Model model, @PathVariable("playerid") String playerid) {
		Player player = playerService.getPlayerById(playerid);
		model.addAttribute("playerid", player.getPlayerid());
		model.addAttribute("playername", player.getPlayername());
		model.addAttribute("country", player.getCountry());
		model.addAttribute("sports", player.getSports());
		
		return "player";
	}

	
	@RequestMapping(value = "/updatePlayer", method = RequestMethod.PUT)
	public String updatePlayer() {
		return "index";
	}

}
