package com.synechron.example.interview.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class InvalidWordException extends RuntimeException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new invalid word exception.
	 */
	public InvalidWordException() {
		super();
	}

	/**
	 * Instantiates a new invalid word exception.
	 *
	 * @param message the message
	 */
	public InvalidWordException(String message) {
		super(message);
	}

}
