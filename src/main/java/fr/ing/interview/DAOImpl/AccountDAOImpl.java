package fr.ing.interview.DAOImpl;

import fr.ing.interview.DAO.AccountDAO;
import fr.ing.interview.Model.Account;
import static fr.ing.interview.Constants.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	JdbcTemplate template;

	private static Logger LOGGER = LoggerFactory.getLogger(AccountDAOImpl.class);

	@Override
	public Account save(Account account) {
		int updateCount = 0;
	     LocalDateTime currentTime = LocalDateTime.now();
	      LocalDate modifiedDate = currentTime.toLocalDate();

		String query = "update  account set current_balance=?,modified_date=? where account_number=?";
		updateCount = template.update(query, account.getCurrentBalance(), modifiedDate,
				account.getAccountNumber());
		if (updateCount > 0) {
			LOGGER.debug("Inserted Succcesfully ");
			account.setMessage(successMsg);
		} else {
			LOGGER.error("failedMsg");
		}
		return account;

	}

	@Override
	public Account findByAccountNumberEquals(String accountNumber) {
		String query = "SELECT * FROM account WHERE account_number=?";
		Account account = template.queryForObject(query, new Object[] { accountNumber },
				new BeanPropertyRowMapper<>(Account.class));

		return account;

	}

	public Account fetchBalance(String accountNumber) {
		String query = "SELECT current_balance FROM account WHERE account_number=?";
		Account account = template.queryForObject(query, new Object[] { accountNumber },
				new BeanPropertyRowMapper<>(Account.class));

		return account;
	}


}
