package com.synechron.example.interview.translator.languages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * The Class GermanTranslatorTests.
 */
public class GermanTranslatorTests {

	/** The translator. */
	private static GermanTranslator translator;

	/**
	 * Initialize and set up.
	 */
	@BeforeAll
	public static void initializeAndSetUp() {
		translator = new GermanTranslator();
	}

	/**
	 * Identify equivalent word positive test case.
	 */
	@Test
	void identifyEqualentWord_positive() {
		assertEquals("word", translator.identifyEquivalentWord("word"));
	}

	/**
	 * Identify equivalent word negative test case.
	 */
	@Test
	void identifyEqualentWord_negative() {
		assertNull(translator.identifyEquivalentWord("flower"));
	}

}
