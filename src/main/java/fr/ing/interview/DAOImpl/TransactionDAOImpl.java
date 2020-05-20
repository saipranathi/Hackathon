package fr.ing.interview.DAOImpl;

import fr.ing.interview.DAO.TransactionDAO;
import fr.ing.interview.Model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

	@Autowired
	JdbcTemplate template;

	public int save(Transaction account) {
		String query = "INSERT INTO transaction(transaction_id,account_number,transaction_amount,type) VALUES(?,?,?,?)";

		 return template.update(query, account.getTransactionId(), account.getAccountNumber(),
				account.getTransactionAmount(), account.getType());

	}

}
