package com.revature.basicbankingapp.beans;

import java.util.List;

public class BankAccount {
	
	private int id;
	private String accountNumber;
	private double balance;
	private List<BankAccount> accounts;
	
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BankAccount(String accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}


	public BankAccount(int id, String accountNumber, double balance, List<BankAccount> accounts) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accounts = accounts;
	}//constructor using all fields


	public BankAccount(int id, String accountNumber, double balance) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}//constructor without List<BankAccount>


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}


	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}


	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}


	/**
	 * @return the accounts
	 */
	public List<BankAccount> getAccounts() {
		return accounts;
	}


	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}


	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance + ", accounts="
				+ accounts + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
