package com.revature.basicbankingapp.views;

import java.util.concurrent.TimeUnit;

import com.revature.basicbankingapp.services.AccountServices;
import com.revature.basicbankingapp.util.ScannerUtil;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TransactionsScreen implements View{
	AccountServices accountService = new AccountServices();
	public View screenOptions() {
		
		System.out.println();
		boolean exit = false;
		int selection =0;
		do {
		System.out.println("1.Balance");
		System.out.println("2.Deposit");
		System.out.println("3.Withdraw");
		System.out.println("4.Transfer");
		System.out.println("0.exit");
		if(selection == 0)
			exit = true;
		
		selection = ScannerUtil.getNumericChoice(4);
		
		switch (selection) {
		case 1: {
		 this.accountService.showBalance();
		 break;
		}
		
		case 2:{ 
		 this.accountService.Deposit();
		 break;
		 }
		
		case 3:{
			this.accountService.Withdraw();
			break;	
		}
		
		case 4:{
			this.accountService.Transfer();
			break;	
		}
			
		
		case 0 :{
		
		    try {
		    	System.out.println("Good bye");
		    	//exit = true;
		    	TimeUnit.SECONDS.sleep(1); 	
		    }//end try
		    
		    catch (InterruptedException e) {
		    	
		    	System.out.println("Everything is fine");
		    }//end catch
			
		}//end case 0
		break;
		
	
		}//end switch 
		
		
		}while(selection!= 0);
		
		return  new WelcomeScreen();
		
		
	}//View screenOptions
		

}// end class TransactionsScreen
