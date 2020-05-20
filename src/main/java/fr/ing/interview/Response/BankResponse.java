package fr.ing.interview.Response;

import static fr.ing.interview.Constants.resMsg;

import java.util.List;

import fr.ing.interview.Model.Account;
import fr.ing.interview.Model.Transaction;

public class BankResponse {

	private Account AccountDetails;
	private List<Transaction> TransactionDetailsList;
	private String ErrorMessage;

	public String getErrorMessage() {
		return ErrorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

	public Account getAccountDetails() {
		return AccountDetails;
	}

	public void setAccountDetails(Account accountDetails) {
		AccountDetails = accountDetails;
	}

	public BankResponse(Account accountDetails, String errorMessage) {
		super();
		AccountDetails = accountDetails;
		ErrorMessage = errorMessage;
	}


	public BankResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankResponse setExceptionData()
	{
		BankResponse res= new BankResponse();
		 res.setErrorMessage(resMsg);
		 return res;
	}


	public List<Transaction> getTransactionDetailsList() {
		return TransactionDetailsList;
	}


	public void setTransactionDetailsList(List<Transaction> transactionDetailsList) {
		TransactionDetailsList = transactionDetailsList;
	}
	

}
