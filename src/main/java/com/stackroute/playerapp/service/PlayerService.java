package com.stackroute.playerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.playerapp.model.Player;
import com.stackroute.playerapp.repository.PlayerRepository;

@Service
public class PlayerService{


	PlayerRepository playerRepository;
	
	@Autowired
	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	
	public Player addPlayer(Player player) {
		Player addedPlayer = playerRepository.addPlayer(player);
		return addedPlayer;
	}
	
	public List<Player> getAllPlayers() {
		return playerRepository.getAllPlayers();
	}
	
	public Player deletePlayer(String playerid) {
		return playerRepository.deletePlayer(playerid);
	}
	
	public Player getPlayerById(String playerid) {
		return playerRepository.getPlayerById(playerid);
	}
	
	public Player updatePlayer(Player player) {
		return playerRepository.updatePlayer(player);
	}
}
