package com.revature.basicbankingapp.services;

import com.revature.basicbankingapp.beans.BankAccount;

import java.util.List;
import java.util.Set;



public interface Services {
	
	
	//public void createUser(int id, String firstName,String lastName,String userName, String passWord, String email);
	
	//public void createUserAccount(String firstName, String lastName, String email, String phone, List<BankAccount> accounts);
	
	public void logIn(String userName, String password);
	
	public double deposit (double amount);
	
	public double withdraw (double amount);
	
	// Transfer money between accounts
	public void  transferMoney(BankAccount account1, BankAccount account2, double amount);


}
