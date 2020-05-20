package fr.ing.interview.Model;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@Column	
	String accountNumber;
	String accountName;
    BigDecimal currentBalance;
    char active;
    Date modifiedDate;
    Timestamp createdDate;
    @Transient
    String message;

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public char getActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Account(String accountNumber, String accountName, BigDecimal currentBalance, char active,
			Timestamp modifiedDate, Timestamp createdDate) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.currentBalance = currentBalance;
		this.active = active;
		this.modifiedDate = modifiedDate;
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	

}
