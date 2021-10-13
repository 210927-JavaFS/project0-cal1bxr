package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDAO {
	public List<User> findAll();
	public User findUser(String username);
	public boolean addUser(User user);
	public User getRole(String username);
	public User setRole(String username);
	public boolean accActive(String username);
	public User getPassword(String username);
}
