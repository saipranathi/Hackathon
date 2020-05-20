package fr.ing.interview.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import fr.ing.interview.Model.Account;
import fr.ing.interview.Model.TransactionRequest;
import static fr.ing.interview.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class TestAccountService {

	@InjectMocks
	static AccountService accountService;

	private static TransactionRequest a1;
	private static Account bal;

	@BeforeClass
	public static void setUp() throws Exception {
		accountService = mock(AccountService.class);

		a1 = new TransactionRequest("200", testAmt);
		bal = new Account(null, null, testBal, '\u0000', null, null);

		when(accountService.Deposit(a1)).thenReturn("400");
		when(accountService.FetchBalance("300")).thenReturn(bal);
		when(accountService.WithDrawAmount(a1)).thenReturn("400");

	}

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testDeposit() throws Exception {
		String acc = accountService.Deposit(a1);
		assertEquals("400", acc);

	}

	@Test
	public void testFetchBalance() throws Exception {

		Account acc = accountService.FetchBalance("300");
		assertEquals(testBal, acc.getCurrentBalance());

	}
	
	@Test
	public void testWithDrawAmount() throws Exception {
		String acc = accountService.WithDrawAmount(a1);
		assertEquals("400", acc);


	}


}
