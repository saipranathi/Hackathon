package fr.ing.interview.DAOImpl;

import fr.ing.interview.DAO.AccountDAO;
import fr.ing.interview.Model.Account;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	JdbcTemplate template;

	@Override
	public int save(Account account) {
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate modifiedDate = currentTime.toLocalDate();

		String query = "update  account set current_balance=?,modified_date=? where account_number=?";
		return template.update(query, account.getCurrentBalance(), modifiedDate, account.getAccountNumber());

	}

	@Override
	public Account findByAccountNumberEquals(String accountNumber) {
		String query = "SELECT * FROM account WHERE account_number=?";
		Account account = template.queryForObject(query, new Object[] { accountNumber },
				new BeanPropertyRowMapper<>(Account.class));
		return account;
	}

	@Override
	public Account fetchBalance(String accountNumber) {
		String query = "SELECT current_balance FROM account WHERE account_number=?";
		Account account = template.queryForObject(query, new Object[] { accountNumber },
				new BeanPropertyRowMapper<>(Account.class));

		return account;
	}

}
