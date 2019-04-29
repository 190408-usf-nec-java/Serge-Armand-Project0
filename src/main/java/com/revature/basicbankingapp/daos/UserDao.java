package com.revature.basicbankingapp.daos;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.basicbankingapp.beans.User;
import com.revature.basicbankingapp.util.ConnectionUtil;

public class UserDao {
	
	
	public void saveUser(User user) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO users (first_name, last_name, user_name, pass_word, email) VALUES " + "('" + user.getFirstName()
					+ "', '" + user.getLastName() + "', '" + "','"+ user.getUserName() + "','"+ user.getPassWord() +"','"+user.getEmail() + "') RETURNING id";
			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				int id = rs.getInt("id");
				user.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//end method saveUser
	
	public void safeSaveUser(User user) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO users (first_name, last_name, user_name, pass_word,acct_number, email) VALUES " + 
		"(?, ?, ?, ?, ?,?) RETURNING id";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getPassWord());
			ps.setString(5, user.getAccountNumber());
			ps.setString(6, user.getEmail());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				user.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<User> getUsersByLastName(String lastName) {
		List<User> users = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT id, first_name, user_name, pass_word, email FROM users WHERE last_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, lastName);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String acctNum  = rs.getString("acct_num");
				String email = rs.getString("email");
				users.add(new User(id, firstName, lastName, userName, passWord,acctNum, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}// end method getUserByLastName
	
	
	
	public List<User> getUserByEmail(String email) {
		List<User> users = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT id, first_name,last_name, user_name, pass_word FROM users WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String acctNum  = rs.getString("acct_num");
				users.add(new User(id, firstName, lastName, userName, passWord,acctNum, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}//end method getUsersByemail
	
	public List<User> getUsersByFirstName(String firstName) {
		List<User> users = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT id, last_name, user_name, pass_word, email FROM users WHERE first_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, firstName);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String lastName = rs.getString("last_name");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				String acctNum  = rs.getString("acct_num");
				String email = rs.getString("email");
				users.add(new User(id, firstName, lastName, userName, passWord,acctNum, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}//end method getUsersByFirstName
	
	
	
	
	
	
	
		
		public  User getUserById (int id) {
			User user = null;

			try (Connection conn = ConnectionUtil.getConnection()) {
				String sql = "SELECT first_name, last_name,user_name,pass_word, email FROM users WHERE id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setInt(1, id);

				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					String userName = rs.getString("user_name");
					String passWord = rs.getString("pass_word");
					String acctNum  = rs.getString("acct_num");
					String email = rs.getString("email");
					user = new User( id,firstName, lastName, userName,passWord,acctNum, email);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return user;
		}// end getUserById
		
	}//end class userDao


