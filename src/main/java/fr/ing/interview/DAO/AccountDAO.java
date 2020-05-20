package fr.ing.interview.DAO;

import fr.ing.interview.Model.Account;

public interface AccountDAO {

	public int save(Account fromAccount);

	public Account findByAccountNumberEquals(String accountNumber);

	public Account fetchBalance(String accountNumber);

}
