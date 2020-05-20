package fr.ing.interview.ServiceImpl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static fr.ing.interview.Constants.*;

import fr.ing.interview.DAO.AccountDAO;
import fr.ing.interview.DAO.TransactionDAO;
import fr.ing.interview.Exception.MinimumAmountException;
import fr.ing.interview.Model.Account;
import fr.ing.interview.Model.Transaction;
import fr.ing.interview.Model.TransactionRequest;
import fr.ing.interview.Service.AccountService;

@Service
public class AccountServiceimpl implements AccountService {

	@Autowired
	AccountDAO accountDao;

	@Autowired
	TransactionDAO transactionDao;

	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public String Deposit(TransactionRequest request) throws Exception {
		String accountNumber = request.getAccountNumber();
		BigDecimal amount = request.getAmount();

		Account account = accountDao.findByAccountNumberEquals(accountNumber);
		account.setCurrentBalance(account.getCurrentBalance().add(amount));
		accountDao.save(account);
		transactionDao.save(new Transaction(0L, accountNumber, credited, amount));
		return account.getAccountNumber();

	}

	@Override
	public Account FetchBalance(String accountNumber) throws Exception {
		Account acc = new Account();
		acc = accountDao.fetchBalance(accountNumber);
		acc.setMessage(balance);
		return acc;
	}

	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public String WithDrawAmount(TransactionRequest request) throws Exception, MinimumAmountException {
		String accountNumber = request.getAccountNumber();
		BigDecimal amount = request.getAmount();

		Account account = accountDao.findByAccountNumberEquals(accountNumber);
		if (request.getAmount().compareTo(account.getCurrentBalance()) == 1) {
			throw new MinimumAmountException("No Sufficient Balance");

		}

		account.setCurrentBalance(account.getCurrentBalance().subtract(amount));
		accountDao.save(account);
		transactionDao.save(new Transaction(0L, accountNumber, debited, amount));
		return account.getAccountNumber();
	}

}
