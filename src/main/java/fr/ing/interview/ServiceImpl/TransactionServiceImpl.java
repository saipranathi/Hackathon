package fr.ing.interview.ServiceImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ing.interview.DAO.TransactionDAO;
import fr.ing.interview.Model.Transaction;
import fr.ing.interview.Response.BankResponse;
import fr.ing.interview.Service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDAO transactionDao;

	@Override
	public BankResponse displayTransactions(String accountNumber) throws Exception {
		BankResponse response = new BankResponse();
		List<Transaction> Txns=new ArrayList<Transaction>();
		Txns = transactionDao.fetchTxnList(accountNumber);
		response.setTransactionDetailsList(Txns);
		return response;
	}

	
	 

}
