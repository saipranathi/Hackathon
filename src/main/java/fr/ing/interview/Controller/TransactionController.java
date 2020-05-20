package fr.ing.interview.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.ing.interview.Model.Transaction;
import fr.ing.interview.Service.TransactionService;

@Controller
@EnableAutoConfiguration
@RequestMapping("/transactions")
public class TransactionController {

	private static Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired(required = true)
	TransactionService transactionService;

	@GetMapping(value = "/displayTxn/{accountNumber}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<Transaction> DisplayTxn(@PathVariable("accountNumber") String accountNumber) throws Exception {
		try {
			return transactionService.displayTransactions(accountNumber);
		}

		catch (Exception ex) {
			logger.error("Exception Occured", ex);
			throw new Exception("Transaction Failed  " + ex.getMessage());

		}

	}
}
