package fr.ing.interview.Exception;

public class ExceptionMessage {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ExceptionMessage(String message) {
		super();
		this.message = message;
	}

}
