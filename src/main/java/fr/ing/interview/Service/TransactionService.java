package fr.ing.interview.Service;

import java.util.List;

import fr.ing.interview.Exception.AccountNumberNotFoundException;
import fr.ing.interview.Model.Transaction;

public interface TransactionService {

	public List<Transaction> displayTransactions(String request) throws Exception, AccountNumberNotFoundException;

}
