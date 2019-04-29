package com.revature.basicbankingapp.services;

import com.revature.basicbankingapp.beans.BankAccount;
import com.revature.basicbankingapp.beans.User;
import com.revature.basicbankingapp.daos.UserDao;
import com.revature.basicbankingapp.services.AccountServices;
import com.revature.basicbankingapp.daos.BankAccountDao;
import com.revature.basicbankingapp.util.ConnectionUtil;
import com.revature.basicbankingapp.util.ScannerUtil;
import com.revature.basicbankingapp.services.UserService;
import com.revature.basicbankingapp.views.TransactionsScreen;
import com.revature.basicbankingapp.views.View;
import com.revature.basicbankingapp.views.WelcomeScreen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//import com.revature.basicbankingapp.services.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

public class UserService {
	
	public static String acct;
	
	//default constructor
	public UserService() {
	}
	
	private int randomGenerator(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}// end randomGenerator

	
	UserDao userDao = new UserDao();
	BankAccountDao accountDao = new BankAccountDao();

	public void setDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * Handles creation workflow for User bean
	 */

	List<Integer> accountNumbers = new ArrayList<>();

	int acctNo = randomGenerator(30000, 40000);

	
	public User createUser() {
		
		int id = 0;// use this value to create the object
					// it will be reset in dao
		

		System.out.println("Please enter user's first name: ");
		String fName = ScannerUtil.getLine();

		System.out.println("Please enter user's last name: ");
		String lName = ScannerUtil.getLine();

		System.out.println("Please enter user's userName: ");
		String uName = ScannerUtil.getLine();

		System.out.println("Please enter user's  passWord: ");
		String pWord = ScannerUtil.getLine();

		System.out.println("Please enter user's email address: ");
		String email = ScannerUtil.getLine();

		// Validate all this data
		
        //change random number to string
		 acct = Integer.toString(acctNo);
		 
		System.out.println("Account Number" + acct);

		User user = new User(id, fName, lName, uName, pWord, acct, email);
         
		// Upon signing User is automatically assigned an account number with $0.0 
		BankAccount newAccount = new BankAccount(0, acct, 0.00);

		userDao.safeSaveUser(user);   // user is saved in the database 
		accountDao.safeSaveAccount(newAccount); //new account is a saved in the database
		return user;

	}

	public View login( ) {

		// Will hold up loaded user names and passwords from the database.
		// HashSet hold the singularity of a set and the indexing feature of table
		Set<String> usernameSet = new HashSet<>();
		Set<String> passwordSet = new HashSet<>();

		Boolean validUser = false;
		Boolean validPassword = false;

			try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "select user_name, pass_word  from users;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usernameSet.add(rs.getString(1));
				passwordSet.add(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}
        int counter=0;
		while (!validUser && !validPassword)  {
			System.out.println("Enter Username:");
			String userName = ScannerUtil.getLine();				
			System.out.println("Enter password:");
			String passWord = ScannerUtil.getLine();
			counter++;
			if((counter > 5)){
				System.out.println("Your session has been ended");
				System.out.println("Please find your right credentials");
				return new WelcomeScreen();
			
			}//end of else if
			
			if ((usernameSet.contains(userName) && (passwordSet.contains(passWord)))) {
				return new TransactionsScreen();
			} //end if
			
			else{
				System.out.println("Ivalid username or passwod.");
				System.out.println ("Please try again.");
			}//end of else
			
	}//end while loop
		
		return null;//default return
		
}//end of method login


}// end class UserService
