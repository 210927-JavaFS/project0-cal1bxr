package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDAO {
	public List<User> findAll();
	public User findUser(String username);
	public boolean addUser(User user);
}
