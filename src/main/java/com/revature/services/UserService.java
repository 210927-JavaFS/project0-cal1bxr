package com.revature.services;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.User;

public class UserService {
	private UserDAO userDao = new UserDAOImpl();
	
	public List<User> findAllAccounts(){
		return userDao.findAll();
	}
	
	public User findByUsername(String username) {
		return userDao.findUser(username);
	}
	
	public boolean newUser(User user) {
		return userDao.addUser(user);
	}
}
