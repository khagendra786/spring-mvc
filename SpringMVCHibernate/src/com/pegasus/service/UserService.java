package com.pegasus.service;

import java.util.List;

import com.pegasus.model.User;

public interface UserService {

	public void registerUser(User user);
	public User loginUser(String username);
	public List<User> listUsers();
}
