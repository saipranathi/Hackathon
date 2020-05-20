package fr.ing.interview.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import static fr.ing.interview.Constants.*;

import fr.ing.interview.Exception.MinimumAmountException;
import fr.ing.interview.Model.Account;
import fr.ing.interview.Model.TransactionRequest;
import fr.ing.interview.Service.AccountService;

@Controller
@EnableAutoConfiguration
@RequestMapping("/account")
public class AccountController {

	private static Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired(required = true)
	AccountService accountService;

	@PostMapping(value = "/depositAmount", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public String DepositAmount(@RequestBody TransactionRequest request) throws Exception {
		logger.info("Start of DepositAmount() API,Its input is AccountNumber '{}' and DepositAmount '{}'",
				request.getAccountNumber(), request.getAmount());
		String res = null;
		if (!(request.getAmount().compareTo(minAmt) == 1)) {
			throw new MinimumAmountException("Amount Greater than of 0.01 is required");

		}
		res = accountService.Deposit(request);
		logger.info("End of DepositAmount() API,It output is AccountNumber '{}' ",res);
		return res;

	}

	@GetMapping(value = "/getCurrentBalnce/{accountNumber}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Account GetCurrentBalance(@PathVariable("accountNumber") String accountNumber) throws Exception {
		logger.info("Start of GetCurrentBalance() API,It input is AccountNumber '{}'", accountNumber);
		Account response = new Account();
		response = accountService.FetchBalance(accountNumber);
		logger.info("End of GetCurrentBalance() API,It output is Account Object with currentBalance '{}' and Message '{}'",
				response.getCurrentBalance(), response.getMessage());
		return response;
	}

	@PostMapping(value = "/withDrawAmount", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public String WithDrawAmount(@RequestBody TransactionRequest request) throws Exception {
		logger.info("Start of WithDrawAmount() API,It input is AccountNumber '{}' and '{}'Amount to withdraw",
				request.getAccountNumber(), request.getAmount());
		String res = null;
		res = accountService.WithDrawAmount(request);

		logger.info("End of WithDrawAmount() API,It output is AccountNumber '{}' ", request.getAccountNumber());
		return res;
	}

}
