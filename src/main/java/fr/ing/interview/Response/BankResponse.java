package fr.ing.interview.Response;

import fr.ing.interview.Model.Account;

public class BankResponse {

	private Account AccountDetails;
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

}
