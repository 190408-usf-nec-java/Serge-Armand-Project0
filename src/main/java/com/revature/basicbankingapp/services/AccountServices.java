package com.revature.basicbankingapp.services;

import com.revature.basicbankingapp.beans.BankAccount;
import com.revature.basicbankingapp.beans.User;
import com.revature.basicbankingapp.daos.BankAccountDao;
import com.revature.basicbankingapp.daos.UserDao;
import com.revature.basicbankingapp.util.ScannerUtil;
import com.revature.basicbankingapp.services.UserService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AccountServices {
	
	UserService service = new UserService();
	
	BankAccountDao accountDao=new BankAccountDao();
	
	public void setDao(BankAccountDao accountDao) {
		this.accountDao = accountDao;
	}// end method setDao
	
	public BankAccount createBanKAccount(int id,String acctNum,int balance ) {
		
		BankAccount account = new BankAccount(id,acctNum,balance );
		
		return account;
		
	}
	 
    public void showBalance(){
    	System.out.println("Enter account number");
    	 String acctNum =ScannerUtil.getLine();
    	 this.accountDao.showBalance(acctNum);	 	 
      }//end method
	
	public void Deposit() {
		 System.out.println ("Please enter your account number");
		 String acctNum =ScannerUtil.getLine();
		 boolean continueLoop = true;
		 double amount =0.0;
		 Scanner reader = new Scanner(System.in);
		do {
			try{
				
				System.out.println("Please Enter the amount to deposit");
				 reader = new Scanner(System.in);
				 amount = reader.nextDouble(); 
				 continueLoop = false;	
			}//end try
			
			catch(InputMismatchException inputMismatchException){
				System.err.printf("\nException: %s\n", inputMismatchException);
				reader.nextLine();
				System.out.println("You must enter a numeric value");
			}
			
		}while(continueLoop);
			
		this.accountDao.Deposit(acctNum,amount);
	}
	
	public void Withdraw() {
		System.out.println ("Please enter your account number");
		String acctNum =ScannerUtil.getLine();
		 boolean continueLoop = true;
		 double amount =0.0;
		 Scanner reader = new Scanner(System.in);
		 
		 do {
				try{
					
					System.out.println("Please Enter the amount to be withdrawn");
					 reader = new Scanner(System.in);
					 amount = reader.nextDouble(); 
					 continueLoop = false;	
				}//end try
				
				catch(InputMismatchException inputMismatchException){
					System.err.printf("\nException: %s\n", inputMismatchException);
					reader.nextLine();
					System.out.println("You must enter a numeric value");
				}
				
			}while(continueLoop);
		 
	    this.accountDao.Withdraw(acctNum,amount);
	}// end method withdraw
	
	public void Transfer() {
		System.out.println ("Please enter acct number to withdraw from");
		String acctNum1 =ScannerUtil.getLine();
		System.out.println ("Please enter acct number to transfer to");
		String acctNum2 =ScannerUtil.getLine();	
		boolean continueLoop = true;
		double amount =0.0;
		Scanner reader = new Scanner(System.in);
		 
		 do {
				try{
					
					System.out.println("Please Enter the amount to tranfer");
					 reader = new Scanner(System.in);
					 amount = reader.nextDouble(); 
					 continueLoop = false;	
				}//end try
				
				catch(InputMismatchException inputMismatchException){
					System.err.printf("\nException: %s\n", inputMismatchException);
					reader.nextLine();
					System.out.println("You must enter a numeric value");
				}
				
			}while(continueLoop);
		 
		this.accountDao.Transfer(acctNum1,acctNum2,amount);
		
	}
	

}// end class AccountServices
