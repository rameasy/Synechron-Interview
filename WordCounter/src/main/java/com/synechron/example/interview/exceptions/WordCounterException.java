package com.synechron.example.interview.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class WordCounterException.
 */
@Setter
@Getter
@ToString
public class WordCounterException extends RuntimeException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new word counter exception.
	 */
	public WordCounterException() {
		super();
	}

	/**
	 * Instantiates a new word counter exception.
	 *
	 * @param message the message
	 */
	public WordCounterException(String message) {
		super(message);
	}

}
