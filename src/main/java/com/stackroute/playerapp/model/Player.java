package com.stackroute.playerapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Player {
	
	@Id
	private String playerid;
	private String playername;
	private String country;
	private String sports;
	
	public Player() {
		
	}

	public Player(String playerid, String playername, String country, String sports) {
		super();
		this.playerid = playerid;
		this.playername = playername;
		this.country = country;
		this.sports = sports;
	}

	public String getPlayerid() {
		return playerid;
	}

	public void setPlayerid(String playerid) {
		this.playerid = playerid;
	}

	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSports() {
		return sports;
	}

	public void setSports(String sports) {
		this.sports = sports;
	}

	@Override
	public String toString() {
		return "Player [playerid=" + playerid + ", playername=" + playername + ", country=" + country + ", sports="
				+ sports + "]";
	}
	
	

}
