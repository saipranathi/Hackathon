package fr.ing.interview.Model;

import java.math.BigDecimal;


public class TransactionRequest {

	private String AccountNumber;

	private BigDecimal amount;
	

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public TransactionRequest(String accountNumber, BigDecimal amount) {
		super();
		AccountNumber = accountNumber;
		this.amount = amount;
	}
	
	

}
