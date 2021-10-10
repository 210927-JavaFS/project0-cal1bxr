package com.revature;
import com.revature.controllers.MenuController;

public class Driver {

	private static MenuController menuController = new MenuController();
	
	public static void main(String[] args) {
		menuController.welcomeMenu();
	}

}