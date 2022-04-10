package com.kata.bank;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Client {
	
	private int id;

	private String firstName;

	private String lastName;

	private Date birthDate;

	private String address;

	private String phone;

	private BankAccount bankAccount;
	
	private List<Transaction> transactions;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Transaction addTransaction(TransactionType transactionType, double amount) {
		switch(transactionType) {
			case DEPOSIT: {
				return new Transaction(LocalDateTime.now(), amount);
			}
			case WITHDRAWAL: {
				return new Transaction(LocalDateTime.now(), amount);
			}
			default: {
				return null;
			}
		}
	}
}
