package org.startupfactory.exercise3.readcons;

public class ConsoleReadException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1799479548943375043L;
	/**
	 * Default constructor for the exception.
	 */
	public ConsoleReadException() {
		super();
	}

	/**
	 * Constructor for the exception using a message.
	 * 
	 * @param message
	 *            the message of the exception
	 */
	public ConsoleReadException(String message) {
		super(message);
	}

	/**
	 * Used for chaining exceptions.
	 * 
	 * @param message
	 *            the message of the exception.
	 * @param cause
	 *            the exception that caused the exception.
	 */
	public ConsoleReadException(String message, Throwable cause) {
		super(message, cause);
	}
}
