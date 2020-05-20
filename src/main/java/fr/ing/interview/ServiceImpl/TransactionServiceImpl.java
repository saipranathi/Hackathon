package fr.ing.interview.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ing.interview.DAO.AccountDAO;
import fr.ing.interview.DAO.TransactionDAO;
import fr.ing.interview.Exception.AccountNumberNotFoundException;
import fr.ing.interview.Model.Account;
import fr.ing.interview.Model.Transaction;
import fr.ing.interview.Service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDAO transactionDao;

	@Autowired
	AccountDAO accountDao;

	@Override
	public List<Transaction> displayTransactions(String accountNumber)
			throws Exception, AccountNumberNotFoundException {
		List<Transaction> txns = new ArrayList<Transaction>();
		Account account = accountDao.findByAccountNumberEquals(accountNumber);

		if (null != account.getAccountNumber()) {
			txns = transactionDao.fetchTxnList(accountNumber);

		} else {
			throw new AccountNumberNotFoundException("AccountNumber doesnt exist");

		}
		return txns;
	}

}
