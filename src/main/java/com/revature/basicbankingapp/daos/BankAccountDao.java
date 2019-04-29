package com.revature.basicbankingapp.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.basicbankingapp.beans.BankAccount;
import com.revature.basicbankingapp.util.ConnectionUtil;
import com.revature.basicbankingapp.util.ScannerUtil;


public class BankAccountDao {

	
	public void safeSaveAccount(BankAccount account) {
		
		int id = 0;
		
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "insert into user_account(acct_number, balance) values" 
		+ "(?,?) returning id";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, account.getAccountNumber());
			ps.setDouble(2, account.getBalance());
			
			System.out.println("Account Num:" + account.getAccountNumber());
			System.out.println("Balance:" + account.getBalance() );
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				 id = rs.getInt("id");
				account.setId(id);
		}	
			
		}//end try
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}//end method safeSaveAccount
	 
	
	public void showBalance(String acctNum) {
		try (Connection conn = ConnectionUtil.getConnection()){	
		String sql = "select balance from user_account where acct_number = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, acctNum);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
		 rs.getDouble("balance");
		 System.out.println("Your balance is: "+ rs.getDouble("balance"));
			}
		
		catch(SQLException e){
			e.printStackTrace();
	}
		
}// end show balance		
		
	public void Deposit( String acctNum, double amount){
		try (Connection conn = ConnectionUtil.getConnection()){
			if(amount>0.0) {
			String sql = "update user_account set balance = balance + ? where acct_number = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setString(2, acctNum);
			
		ps.executeUpdate();
		
			}//end  if
			else {
				System.out.println("You have entered: "+amount);
				System.out.println("Please enter a positive amount");
		}
			
	}//end of try
		
		catch(SQLException e){
			e.printStackTrace();
		}	
		
	}//end method Deposit
	
	
	public void Withdraw( String acctNum, double amount){
		try (Connection conn = ConnectionUtil.getConnection()){
			
	if (amount > 0) {
			
			String sql1 = "select balance from user_account where acct_number = ? ";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setString(1,acctNum);
			ResultSet rs = ps1.executeQuery();
			
			if (rs.next())
			 rs.getDouble("balance");
			
			if ((rs.getDouble("balance"))> amount) {
				
			String sql2 = "update user_account set balance = balance - ? where acct_number = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setDouble(1, amount);
			ps2.setString(2, acctNum);
			
			ps2.executeUpdate();
			}
			else 
				System.out.println("Sorry you don't have sufficient fund for this transaction");
	}
	else 
	{
		System.out.println("You have entered: "+amount);
		System.out.println("Please enter a positive amount");
	}
		
	}	
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}//end method WithDraw
	
	public void Transfer( String acctNum1, String acctNum2, double amount){
		try (Connection conn = ConnectionUtil.getConnection()){
		if(amount>0) {
			String sql = "select balance from user_account where acct_number = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,acctNum1);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			 rs.getDouble("balance");
			if((rs.getDouble("balance")) < (amount))
			 System.out.println("You have insufficient fun for this transaction");
			
			else {	
					
		String sql2 = "update user_account set balance = balance - ? where acct_number = ?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ps2.setDouble(1, amount);
		ps2.setString(2, acctNum1);
	
		ps2.executeUpdate();
		
		String sql3 = "update user_account set balance = balance + ? where acct_number = ?";
		PreparedStatement ps3 = conn.prepareStatement(sql3);
		ps3.setDouble(1, amount);
		ps3.setString(2, acctNum2);

	ps3.executeUpdate();
		
				}//end else	
			
		}//end if
		
		else {
			
			System.out.println("You have entered: "+amount);
			System.out.println("Please enter a positive amount");
			
		}
	}//end try
		
		
			
		
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}//end method Transfer
	
	
}//end class bankAccount


