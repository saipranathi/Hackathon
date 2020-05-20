package fr.ing.interview.Service;

import fr.ing.interview.Response.BankResponse;

public interface TransactionService {

	public BankResponse displayTransactions(String request) throws Exception;

}
