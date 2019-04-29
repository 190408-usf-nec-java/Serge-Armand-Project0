package com.revature.basicbankingapp.launch;

import com.revature.basicbankingapp.beans.User;
import com.revature.basicbankingapp.daos.UserDao;
import com.revature.basicbankingapp.services.UserService;
import com.revature.basicbankingapp.beans.BankAccount;
import com.revature.basicbankingapp.daos.BankAccountDao;
import com.revature.basicbankingapp.util.ConnectionUtil;
import com.revature.basicbankingapp.views.View;
import com.revature.basicbankingapp.views.WelcomeScreen;

import java.sql.SQLException;

public class Launcher {
	
public static void main(String[] args) {
	
	 
	try {
		ConnectionUtil.getConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
View view = new WelcomeScreen();
	
	while(view != null) {
	view = view.screenOptions();
	}
	
	}
}

