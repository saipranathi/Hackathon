package fr.ing.interview.DAO;

import fr.ing.interview.Model.Account;

public interface AccountDAO {

	public Account save(Account fromAccount) ;
    public Account findByAccountNumberEquals(String accountNumber) ;



}
