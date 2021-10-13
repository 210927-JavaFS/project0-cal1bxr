package com.revature;

import com.revature.controllers.MenuController;
import com.revature.models.User;

public class Driver {

	private static MenuController menuController = new MenuController();
	private static User user = new User();

	public static void main(String[] args) {

		user.getPassword();
		menuController.welcomeMenu();
	}



	private User loginMenu(String username, String Password) {
		
		return user;	}
}