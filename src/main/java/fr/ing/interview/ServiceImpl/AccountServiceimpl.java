package fr.ing.interview.ServiceImpl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static fr.ing.interview.Constants.*;

import fr.ing.interview.DAO.AccountDAO;
import fr.ing.interview.DAO.TransactionDAO;
import fr.ing.interview.DAOImpl.AccountDAOImpl;
import fr.ing.interview.Model.Account;
import fr.ing.interview.Model.Transaction;
import fr.ing.interview.Model.TransactionRequest;
import fr.ing.interview.Response.BankResponse;
import fr.ing.interview.Service.AccountService;

@Service
public class AccountServiceimpl implements AccountService {

	@Autowired
	AccountDAO accountDao;

	@Autowired
	TransactionDAO transactionDao;

	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public BankResponse Deposit(TransactionRequest request) throws Exception {
		BankResponse response = new BankResponse();
		String accountNumber = request.getAccountNumber();
		BigDecimal amount = request.getAmount();

		Account account = accountDao.findByAccountNumberEquals(accountNumber);
		if (amount.compareTo(minAmt) == 1 && account.getActive() == 'y') {
			Account acc = new Account();
			account.setCurrentBalance(account.getCurrentBalance().add(amount));
			acc = accountDao.save(account);
			transactionDao.save(new Transaction(0L, accountNumber, credited, amount));
			response.setAccountDetails(acc);
			return response;
		}

		else {
			transactionDao.save(new Transaction(0L, accountNumber, txnFail, amount));
			response.setErrorMessage(failedMsg);
			return response;

		}

	}

	@Override
	public BankResponse FetchBalance(String accountNumber) throws Exception {
		BankResponse response = new BankResponse();
		Account account = accountDao.fetchBalance(accountNumber);
		account.setMessage(balance);
		response.setAccountDetails(account);
		return response;
	}

	
}
