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
import fr.ing.interview.Model.TransactionRequest;
import fr.ing.interview.Response.BankResponse;
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
	public BankResponse DepositAmount(@RequestBody TransactionRequest request) throws Exception {
		BankResponse response= new BankResponse();
		try {
			response = accountService.Deposit(request);
		} catch (Exception e) {
			logger.error("Exception Occured",e);
			response=response.setExceptionData();
		}

		return response;
	}
	
	@GetMapping(value = "/getCurrentBalnce/{accountNumber}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public BankResponse GetCurrentBalance(@PathVariable("accountNumber") String accountNumber) {
		BankResponse response= new BankResponse();
		try {
			response = accountService.FetchBalance(accountNumber);
		} catch (Exception e) {
			logger.error("Exception Occured",e);
			response=response.setExceptionData();

		}

		return response;
	}



}
