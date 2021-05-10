package com.stackroute.playerapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.playerapp.model.Player;

@Repository
@Transactional
public class PlayerRepository {

	// SessionFactory, Session, Query, Transaction
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Player addPlayer(Player player) {
		getCurrentSession().save(player);
		return player;
	}
	
	public List<Player> getAllPlayers() {
		return getCurrentSession().createQuery("from Player").getResultList();
	}
	
	public Player deletePlayer(long playerid) {
		Player player = getCurrentSession().find(Player.class,playerid);
		getCurrentSession().remove(player);
		return player;
	}
	
	public Player updatePlayer(Player player) {
		
		return null;
	}

	public Player getPlayerById(long playerid) {
		return getCurrentSession().find(Player.class,playerid);
	}
	
}
