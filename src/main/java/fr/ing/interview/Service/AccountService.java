package fr.ing.interview.Service;

import fr.ing.interview.Model.TransactionRequest;
import fr.ing.interview.Response.BankResponse;

public interface AccountService {

	public BankResponse  Deposit(TransactionRequest request) throws Exception;

}
