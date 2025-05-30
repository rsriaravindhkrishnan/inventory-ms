package uk.co.prodapt.inventory.exception;

public class DuplicateProductIDException extends RuntimeException{
	public DuplicateProductIDException(String message) {
		super(message);		
	}

}
