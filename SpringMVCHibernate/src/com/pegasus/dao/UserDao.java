package com.pegasus.dao;

import java.util.List;

import com.pegasus.model.User;

public interface UserDao {

	public void registerUser(User user);
	public User loginUser(String username);
	public List<User> listUsers();
}
