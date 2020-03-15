package com.pegasus.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pegasus.model.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registerUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public User loginUser(String username) {
		return (User) sessionFactory.getCurrentSession().get(User.class, username);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}
}
