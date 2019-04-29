package com.revature.basicbankingapp.views;
import java.util.concurrent.TimeUnit;

import com.revature.basicbankingapp.daos.*;
import com.revature.basicbankingapp.services.UserService;
import com.revature.basicbankingapp.views.View;
import com.revature.basicbankingapp.services.AccountServices;


public class CreateAccountScreen implements View{
	public View screenOptions() {
		
		UserService service = new UserService(); 
		service.createUser();
		System.out.println();
		System.out.println("Thank You For Choosing BKBank");
		System.out.println("We are Taking you to the transaction ");
		System.out.println(" in a few seconds");
		
		try {
	    	//System.out.println("Good bye");
	    	TimeUnit.SECONDS.sleep(3); 	
	    }//end try
	    
	    catch (InterruptedException e) {
	    	
	    	System.out.println("Everything is fine");
	    }//end catch
		
		return new  TransactionsScreen();
		//return null;
	}

}
