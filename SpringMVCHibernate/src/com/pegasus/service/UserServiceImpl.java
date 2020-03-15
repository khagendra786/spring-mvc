package com.pegasus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pegasus.dao.UserDao;
import com.pegasus.model.User;

@Service("UserService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void registerUser(User user) {
	userDao.registerUser(user);	
	}

	@Override
	public User loginUser(String username) {
		return userDao.loginUser(username);
	}

	@Override
	public List<User> listUsers() {
		return userDao.listUsers();
	}

}
