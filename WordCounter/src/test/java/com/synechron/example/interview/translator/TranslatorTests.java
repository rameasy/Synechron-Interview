package com.synechron.example.interview.translator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * The Class TranslatorTests.
 */
public class TranslatorTests {

	/** The translator. */
	private static Translator translator = null;

	/**
	 * Initialize and set up.
	 */
	@BeforeAll
	public static void initializeAndSetUp() {
		translator = Translator.getInstance();
	}

	/**
	 * This method test whether the translator object is created multiple times.
	 */
	@Test
	void translateObjectSingletonTest() {
		assertEquals(translator.hashCode(), Translator.getInstance().hashCode());
	}

	/**
	 * Translate positive test case.
	 */
	@Test
	void translate_positive() {
		assertEquals("this", translator.translate("this"));
		assertEquals("flower", translator.translate("flor"));
		assertEquals("word", translator.translate("word"));
	}

	/**
	 * Translate negative test case.
	 */
	@Test
	void translate_negative() {
		assertNotEquals("flor", translator.translate("flor"));
		assertNotEquals("palabra", translator.translate("mot"));
	}
}
