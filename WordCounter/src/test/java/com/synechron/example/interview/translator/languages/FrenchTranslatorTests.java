package com.synechron.example.interview.translator.languages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * The Class FrenchTranslatorTests.
 */
public class FrenchTranslatorTests {

	/** The translator. */
	private static FrenchTranslator translator;

	/**
	 * Initialize and set up.
	 */
	@BeforeAll
	public static void initializeAndSetUp() {
		translator = new FrenchTranslator();
	}

	/**
	 * Identify equivalent word positive positive test case.
	 */
	@Test
	void identifyEquivalentWord_positive() {
		assertEquals("word", translator.identifyEquivalentWord("mot"));
	}

	/**
	 * Identify equivalent word negative test case.
	 */
	@Test
	void identifyEquivalentWord_negative() {
		assertNull(translator.identifyEquivalentWord("flower"));
	}

}
