package com.hilaltasolar.dao;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hilaltasolar.entity.User;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Long insert(User user){
		return (Long) sessionFactory.getCurrentSession().save(user);
	}
	
	public void update(User user){
		sessionFactory.getCurrentSession().update(user);
	}
	
	
	//READ
	public User getFindByUsernameAndPass(String username, String pass){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE username=:username AND password=:pass AND active=:active")
				.setParameter("username", username)
				.setParameter("pass", pass)
				.setParameter("active", true);
		User user = null;
		try{
			user = (User) query.getSingleResult();
		}catch (javax.persistence.NoResultException e) {
			user = null;
			e.printStackTrace();
		}
		return user;
	}
	
	public User getFindByUsername(String username){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE username=:username")
				.setParameter("username", username);
		return (User) query.getSingleResult();
	}
	
	public User getFindByKey(String key){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE myKey=:key")
				.setParameter("key", key);
		User user = null;
		try{
			user = (User) query.getSingleResult();
		}catch (javax.persistence.NoResultException e) {
			user = null;
		}
		return user;
	}
	
}
