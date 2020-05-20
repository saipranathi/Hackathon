package fr.ing.interview.Service;

import fr.ing.interview.Exception.MinimumAmountException;
import fr.ing.interview.Model.Account;
import fr.ing.interview.Model.TransactionRequest;

public interface AccountService {

	public String Deposit(TransactionRequest request) throws Exception;

	public Account FetchBalance(String request) throws Exception;

	public String WithDrawAmount(TransactionRequest request) throws Exception, MinimumAmountException;

}
