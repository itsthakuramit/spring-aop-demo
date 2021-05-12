package com.stackroute.playerapp.repository;

import javax.transaction.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.playerapp.model.User;

@Repository
@Transactional
public class UserRepository {

	// SessionFactory, Session, Query, Transaction
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public User addUser(User user) {
		getCurrentSession().save(user);
		return user;
	}

	public User validate(String username, String password) {
		System.out.println("U :"+username);
		System.out.println("P :"+password);
		User user = (User) getCurrentSession().createQuery("from User u where u.username = :username and u.password = :password")
	    	.setParameter("username", username)
	    	.setParameter("password", password)
	    	.getSingleResult();
	    	

		return user;
	}

	public User getUserByUsername(String username) {
		return getCurrentSession().find(User.class,username);
	}

	
}
