package fr.ing.interview.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MinimumAmountException extends Exception {
	private static final long serialVersionUID = 1L;

	public MinimumAmountException(String msg) {
		super(msg);
	}

}
