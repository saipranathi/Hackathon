package fr.ing.interview.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import fr.ing.interview.Model.Transaction;
import static fr.ing.interview.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class TestTransactionService {
	
	@InjectMocks
	static
	TransactionService transactionService;
	
	private static Transaction txn1;
	private static Transaction txn2;
	static Date date = new Date();
	static Timestamp timestamp = new Timestamp(date.getTime());
	private static List<Transaction> txnList= new ArrayList<Transaction>();


	@BeforeClass
	public static void setUp() throws Exception {
		transactionService = mock(TransactionService.class);
		
		txn1=new Transaction(1L,"400",credited, testBal);
		txn2=new Transaction(2L,"300",credited, testBal);
		txnList.add(txn1);
		txnList.add(txn2);

		when(transactionService.displayTransactions("400")).thenReturn(txnList);

	}
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

    @Test
    public void displayTransactions() throws Exception{
    	List<Transaction> txnList = transactionService.displayTransactions("400");
         
        assertEquals(2, txnList.size());
        Transaction tx = txnList.get(0);

        assertEquals(new Long(1),tx.getTransactionId());
        assertEquals("400", tx.getAccountNumber());
        assertEquals(credited, tx.getType());
        assertEquals(testBal, tx.getTransactionAmount());
}	  




}
