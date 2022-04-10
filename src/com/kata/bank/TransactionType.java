package com.kata.bank;

public enum TransactionType {

	DEPOSIT('D', "Deposit"), WITHDRAWAL('W',"Withdrawal");

	private char code;
	private String label;

	private TransactionType(char code, String label) {
		this.code = code;
		this.label = label;
	}

	public char getCode() {
		return code;
	}

	public String getLabel() {
		return label;
	}
}
