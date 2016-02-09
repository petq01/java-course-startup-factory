package org.startupfactory.exercise3.arrayelem;

public class EmptyListException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8068511312954172677L;
	/**
	 * Default constructor for the exception.
	 */
	public EmptyListException() {
		super();
	}

	/**
	 * Constructor using a message.
	 * 
	 * @param message
	 *            the message to give to the exception.
	 */
	public EmptyListException(String message) {
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
	public EmptyListException(String message, Throwable cause) {
		super(message, cause);
	}

}
