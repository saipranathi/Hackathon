package fr.ing.interview.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.ing.interview.Response.BankResponse;
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
	public BankResponse DisplayTxn(@PathVariable("accountNumber") String accountNumber) throws Exception {
		BankResponse response= new BankResponse();
		try {
			response = transactionService.displayTransactions(accountNumber);
		} catch (Exception e) {
			logger.error("Exception Occured",e);
			response=response.setExceptionData();
		}

		return response;

}
}
