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
	
	public User userRole(String username) {
		return userDao.getRole(username);
	}
	
	public User assignRole(String username) {
		return userDao.setRole(username);
	}
	
	public boolean accActive(boolean accounntActive, String username) {
		return userDao.accActive(accounntActive, username);
	}
	
	public User userPassword(String password) {
		return userDao.getPassword(password);
	}
	
	public boolean addUser(User user) {
				return userDao.addUser(user);
	}
}
