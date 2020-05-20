package fr.ing.interview.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountNumberNotFoundException extends Exception{	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AccountNumberNotFoundException(String message) {
        super(message);
	}


	

}
