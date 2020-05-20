package fr.ing.interview.DAOImpl;

import fr.ing.interview.DAO.TransactionDAO;
import fr.ing.interview.Exception.AccountNumberNotFoundException;
import fr.ing.interview.Model.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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

	@Override
	public List<Transaction> fetchTxnList(String accountNumber) throws AccountNumberNotFoundException {
		String query = "SELECT * FROM transaction where account_number=?";
		List<Transaction> list = new ArrayList<Transaction>();

		return template.query(query, new ResultSetExtractor<List<Transaction>>() {
			@Override
			public List<Transaction> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Transaction t = new Transaction();
					t.setTransactionId(rs.getLong(1));
					t.setAccountNumber(rs.getString(2));
					t.setTransactionAmount(rs.getBigDecimal(3));
					t.setType(rs.getString(4));
					t.setTransactionDateTime(rs.getTimestamp(5));
					list.add(t);
				}
				return list;

			}
		}, accountNumber);

	}

}
