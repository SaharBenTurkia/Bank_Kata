package com.kata.bank;

import java.time.LocalDateTime;

public class StatementPrinting {
	
	private String balance;
	private LocalDateTime date;
	
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String printBalance(Transaction transaction) {
		return  transaction.getType()
				+ " || " + transaction.getAmount()
				+ " || " + transaction.getDateTime();
	}
}
