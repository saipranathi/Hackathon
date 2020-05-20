package fr.ing.interview.ServiceImpl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static fr.ing.interview.Constants.*;
import fr.ing.interview.DAOImpl.AccountDAOImpl;
import fr.ing.interview.DAOImpl.TransactionDAOImpl;
import fr.ing.interview.Model.Account;
import fr.ing.interview.Model.Transaction;
import fr.ing.interview.Model.TransactionRequest;
import fr.ing.interview.Response.BankResponse;
import fr.ing.interview.Service.AccountService;

@Service
public class AccountServiceimpl implements AccountService {

	@Autowired
	AccountDAOImpl accountDao;

	@Autowired
	TransactionDAOImpl transactionDao;

	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public BankResponse Deposit(TransactionRequest request) throws Exception {
		BankResponse response = new BankResponse();
		String accountNumber = request.getAccountNumber();
		BigDecimal amount = request.getAmount();
		String type = request.getType();

		Account account = accountDao.findByAccountNumberEquals(accountNumber);
		if (amount.compareTo(minAmt) == 1 && account.getActive() == 'y') {
			Account acc = new Account();
			account.setCurrentBalance(account.getCurrentBalance().add(amount));
			acc = accountDao.save(account);
			transactionDao.save(new Transaction(0L, accountNumber, type, amount));
			response.setAccountDetails(acc);
			return response;
		}

		else {
			transactionDao.save(new Transaction(0L, accountNumber, txnFail, amount));
			response.setErrorMessage(failedMsg);
			return response;

		}

	}

}
