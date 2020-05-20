package fr.ing.interview.DAO;

import java.util.List;

import fr.ing.interview.Model.Transaction;

public interface TransactionDAO {

	public int save(Transaction fromAccount);

	public List<Transaction> fetchTxnList(String accountNumber);

}
