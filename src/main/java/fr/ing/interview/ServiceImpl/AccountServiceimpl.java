package fr.ing.interview.ServiceImpl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static Logger logger = LoggerFactory.getLogger(AccountServiceimpl.class);

	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public String Deposit(TransactionRequest request) throws Exception {
		logger.info("Start of DepositAmount() service,Its input is AccountNumber '{}' and DepositAmount '{}'",
				request.getAccountNumber(), request.getAmount());

		String accountNumber = request.getAccountNumber();
		BigDecimal amount = request.getAmount();

		Account account = accountDao.findByAccountNumberEquals(accountNumber);
		account.setCurrentBalance(account.getCurrentBalance().add(amount));
		accountDao.save(account);
		transactionDao.save(new Transaction(0L, accountNumber, credited, amount));
		logger.info("End of DepositAmount() Service,It output is AccountNumber '{}' ", account.getAccountNumber());
		return account.getAccountNumber();

	}

	@Override
	public Account FetchBalance(String accountNumber) throws Exception {
		logger.info("Start of GetCurrentBalance() Service,It input is AccountNumber '{}'", accountNumber);
		Account acc = new Account();
		acc = accountDao.fetchBalance(accountNumber);
		acc.setMessage(balance);
		logger.info(
				"End of GetCurrentBalance() API,It output is Account Object with currentBalance '{}' and Message '{}'",
				acc.getCurrentBalance(), acc.getMessage());

		return acc;
	}

	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public String WithDrawAmount(TransactionRequest request) throws Exception, MinimumAmountException {
		logger.info("Start of WithDrawAmount() service,It input is AccountNumber '{}' and '{}'Amount to withdraw",
				request.getAccountNumber(), request.getAmount());

		String accountNumber = request.getAccountNumber();
		BigDecimal amount = request.getAmount();

		Account account = accountDao.findByAccountNumberEquals(accountNumber);
		if (request.getAmount().compareTo(account.getCurrentBalance()) == 1) {
			throw new MinimumAmountException("No Sufficient Balance");

		}

		account.setCurrentBalance(account.getCurrentBalance().subtract(amount));
		accountDao.save(account);
		transactionDao.save(new Transaction(0L, accountNumber, debited, amount));
		logger.info("End of WithDrawAmount() Service,It output is AccountNumber '{}' ",account.getAccountNumber());
		return account.getAccountNumber();

	}

}
