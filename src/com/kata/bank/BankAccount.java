package com.kata.bank;

import java.time.LocalDate;

public class BankAccount {
	
	private int id;
	private Client client;
	private LocalDate creationDate;
	private StatementPrinting statementPrinting;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public StatementPrinting getStatementPrinting() {
		return statementPrinting;
	}
	public void setStatementPrinting(StatementPrinting statementPrinting) {
		this.statementPrinting = statementPrinting;
	}
	
	

}
