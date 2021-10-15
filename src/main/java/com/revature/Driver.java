package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.revature.controllers.MenuController;


public class Driver {

	private static MenuController menuController = new MenuController();
	private static Logger log = LoggerFactory.getLogger(Driver.class);
	public static void main(String[] args) {
		log.info("Entering main menu controller");
		MDC.put("MJ", "1");
//		String password = "Password1";
//		PassEncTech1.passwordEncryption(password);
		menuController.welcomeMenu();
	}
}