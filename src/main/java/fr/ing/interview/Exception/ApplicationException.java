package fr.ing.interview.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationException {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> applicationExceptionHandler(Exception ex) {

		ExceptionMessage msg = new ExceptionMessage(ex.getMessage());
		return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(AccountNumberNotFoundException.class)
	public ResponseEntity<?> accountNumberNotFoundException(Exception ex) {

		ExceptionMessage msg = new ExceptionMessage(ex.getMessage());
		return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(MinimumAmountException.class)
	public ResponseEntity<?> minimumAmountException(Exception ex) {

		ExceptionMessage msg = new ExceptionMessage(ex.getMessage());
		return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
