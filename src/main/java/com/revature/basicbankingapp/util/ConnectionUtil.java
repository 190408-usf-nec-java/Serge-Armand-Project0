package com.revature.basicbankingapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class: DriverManager -> Older way of getting a Connection object to the database
 * Class: DataSource -> Newer way of getting a Connection object to the database
 * Interface: Connection -> Represents an open connection to the database
 *
 */
//How to  create a connection between local machine and database

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
		// JDBC has it's own URL syntax that we will need to use
		// jdbc:postgresql://localhost:5432/postgres

		/*
		 * Why should we use environment variables for these details?
		 * 
		 * Code is shared with many people and is pushed to a repository,
		 * and these connection details could be accessed and abused
		 * if they are pushed into any kind of public space. By using
		 * environment variables, these values stay private even if the
		 * code becomes public, preventing our credentials from becoming
		 * public which would violate the security of our database.
		 */
		
		String url = System.getenv("JDBC_URL");// Where the data base is
		String username = System.getenv("JDBC_LOGIN");//user name of the role on the data base
		String password = System.getenv("JDBC_PASSWORD");//Assigned password
		System.out.println(url);
		Connection connection = DriverManager.getConnection(url, username, password);// connection object between local machine 
		                                                                             // and data base
		return connection;
	}

}