package com.revature.basicbankingapp.views;

import com.revature.basicbankingapp.views.View;
import com.revature.basicbankingapp.util.*;


public class WelcomeScreen implements View {
	
	public View screenOptions() {
		
		System.out.println("\nWelcome to Revature Bank ");
		System.out.println("1. Existing User");
		System.out.println("2. New User");
		System.out.println("0. Quit");
		
        int selection = ScannerUtil.getNumericChoice(3);
        
		switch(selection) {
		case 1: return new LogginScreen();
		case 2: return new CreateAccountScreen();
		case 0: {
				System.out.println("Good bye");
				return null;
			}
		
		default: return null;
		
		}// end switch
		
	}//end method screenOptions

}//end class Welcome Screen 
