package com.revature.basicbankingapp.views;

import java.util.Scanner;

import com.revature.basicbankingapp.services.UserService;

public class LogginScreen implements View {
	
	public View screenOptions() {
		
		System.out.println("****************"
							+ "Login Screen"
							+ "******************");

		UserService service = new UserService();
		return (service.login());// login is implemented in 
		                         // UserServices
		
	} //end method screenOptions

}//end class LogginScreen.
