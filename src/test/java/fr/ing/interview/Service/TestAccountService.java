package fr.ing.interview.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import fr.ing.interview.Model.Account;
import fr.ing.interview.Model.TransactionRequest;
import fr.ing.interview.Response.BankResponse;

import static fr.ing.interview.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class TestAccountService {

	@InjectMocks
	static AccountService accountService;

	private static TransactionRequest a1;
	private static BankResponse res;
	private static Account acc;
	static Date date = new Date();
	static Timestamp timestamp = new Timestamp(date.getTime());

	@BeforeClass
	public static void setUp() throws Exception {
		accountService = mock(AccountService.class);

		a1 = new TransactionRequest("200", testAmt, "credited");
		acc = new Account("200", "saipranathi", testBal, 'y', timestamp, timestamp);
		res = new BankResponse(acc, "null");

		when(accountService.Deposit(a1)).thenReturn(res);

	}

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testDeposit() throws Exception {
		BankResponse acc = accountService.Deposit(a1);
		assertEquals("200", acc.getAccountDetails().getAccountNumber());
		assertEquals("saipranathi", acc.getAccountDetails().getAccountName());
		assertEquals(testBal, acc.getAccountDetails().getCurrentBalance());
		assertEquals('y', acc.getAccountDetails().getActive());
		assertEquals(timestamp, acc.getAccountDetails().getModifiedDate());
		assertEquals(timestamp, acc.getAccountDetails().getCreatedDate());

	}

}
