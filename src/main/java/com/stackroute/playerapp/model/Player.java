package com.stackroute.playerapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="CricketPlayers")
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=40,name="Id")
	private long playerid;
	@Column(length=30,name="Name", nullable=false)
	private String playername;
	@Column(length=30,name="Nationality")
	@NotNull
	@Size(min=5,max=20,message="Nationality of the Sports Person")
	private String country;
	@Column(length=30,name="Game", nullable=false)
	@Length(min=3, max=20)
	private String sports;
	
	
	public Player() {
		
	}

	public Player(long playerid, String playername, String country, String sports) {
		super();
		this.playerid = playerid;
		this.playername = playername;
		this.country = country;
		this.sports = sports;
	}

	public long getPlayerid() {
		return playerid;
	}

	public void setPlayerid(long playerid) {
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
