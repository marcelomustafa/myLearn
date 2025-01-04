package br.com.maripuri.mydom.exception;

public class AnyNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AnyNotFoundException(String message) {
		super(message);
	}

}
