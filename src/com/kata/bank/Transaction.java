package com.kata.bank;

import java.time.LocalDateTime;
import com.kata.bank.TransactionType;

public class Transaction {

	private int id;
	private LocalDateTime datetime;
	private TransactionType type;
	private double amount;
	
	public Transaction(LocalDateTime datetime, double amount) {
		this.datetime = datetime;
		if (amount > 0) {
			this.type = TransactionType.DEPOSIT;
			this.amount = amount;
		}
		if (amount < 0) {
			this.type = TransactionType.WITHDRAWAL;
			this.amount = - amount;
		}
	}
	
	public LocalDateTime getDateTime() {
		return datetime;
	}
	public void setDateTime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
