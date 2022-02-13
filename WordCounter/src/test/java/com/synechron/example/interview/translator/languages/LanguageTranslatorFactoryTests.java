package com.synechron.example.interview.translator.languages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * The Class LanguageTranslatorFactoryTests.
 */
class LanguageTranslatorFactoryTests {

	/**
	 * Gets the language translator test.
	 *
	 * @return the language translator test
	 */
	@Test
	void getLanguageTranslatorTest() {
		assertTrue(LanguageTranslatorFactory.getLanguageTranslator("de") instanceof GermanTranslator);
		assertTrue(LanguageTranslatorFactory.getLanguageTranslator("fr") instanceof FrenchTranslator);
		assertTrue(LanguageTranslatorFactory.getLanguageTranslator("es") instanceof SpanishTranslator);
	}

	/**
	 * Gets the language translator object test.
	 *
	 * @return the language translator object test
	 */
	@Test
	void getLanguageTranslatorObjectTest() {
		assertEquals(LanguageTranslatorFactory.getLanguageTranslator("de").hashCode(),
				LanguageTranslatorFactory.getLanguageTranslator("de").hashCode());

	}

	/**
	 * Gets the language translator exception test case.
	 *
	 * @return the language translator exception case
	 */
	@Test
	void getLanguageTranslator_ExceptionCase() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			LanguageTranslatorFactory.getLanguageTranslator("en");
		});
		assertEquals("No such Translator", exception.getMessage());
	}
}
