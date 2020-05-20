package fr.ing.interview.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ing.interview.Controller.AccountController;
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

	private static Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Override
	public List<Transaction> displayTransactions(String accountNumber)
			throws Exception, AccountNumberNotFoundException {
		logger.info("Start of DisplayTxn() Service,It input is AccountNumber '{}'", accountNumber);
		List<Transaction> txns = new ArrayList<Transaction>();
		Account account = accountDao.findByAccountNumberEquals(accountNumber);

		if (null != account.getAccountNumber()) {
			txns = transactionDao.fetchTxnList(accountNumber);

		} else {
			throw new AccountNumberNotFoundException("AccountNumber doesnt exist");

		}
		logger.info("End of DisplayTxn() Service,It output is TransactionList ");
		return txns;
	}

}
