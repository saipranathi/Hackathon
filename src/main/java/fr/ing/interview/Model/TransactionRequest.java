package fr.ing.interview.Model;

import java.math.BigDecimal;

public class TransactionRequest {

	private String AccountNumber;

	private BigDecimal amount;
	
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

	public TransactionRequest(String accountNumber, BigDecimal amount, String type) {
		super();
		AccountNumber = accountNumber;
		this.amount = amount;
		this.type = type;
	}
	
	

}
