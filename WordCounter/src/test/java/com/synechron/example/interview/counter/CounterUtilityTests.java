package com.synechron.example.interview.counter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.synechron.example.interview.model.Words;

/**
 * The Class CounterUtilityTests.
 */
public class CounterUtilityTests {

	/** The counter utility. */
	private static CounterUtility counterUtility = null;

	/**
	 * Initialize and set up.
	 */
	@BeforeAll
	public static void initializeAndSetUp() {
		counterUtility = new CounterUtility();
	}

	/**
	 * Insert word and count positive test case.
	 */
	@Test
	void insertWordAndCount_positive() {
		counterUtility.insertWord("Flower");
		counterUtility.insertWord("flower");
		counterUtility.insertWord("flOwer");
		assertEquals(3L, counterUtility.getCount("flower").getCount());
	}

	/**
	 * Insert word null check test case.
	 */
	@Test
	void insertWord_nullCheck() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			counterUtility.getCount(null);
		});
		assertEquals("Not a valid word", exception.getMessage());
	}

	/**
	 * Insert word exception case.
	 */
	@Test
	void insertWord_ExceptionCase() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			counterUtility.insertWord("fl0wer");
		});
		assertEquals("Word contains non-alphabetic character/s", exception.getMessage());
	}

	/**
	 * Gets the count exception test case.
	 *
	 * @return the count exception case
	 */
	@Test
	void getCount_ExceptionCase_InvalidWord() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			counterUtility.insertWord("fl0wer");
		});
		assertEquals("Word contains non-alphabetic character/s", exception.getMessage());
	}

	/**
	 * Gets the count exception test case.
	 *
	 * @return the count exception case
	 */
	@Test
	void getCount_ExceptionCase_NewWord() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			counterUtility.getCount("english");
		});
		assertEquals("Unable to find the word", exception.getMessage());
	}

	/**
	 * Gets the all words test.
	 *
	 * @return the all words test
	 */
	@Test
	void getAllWordsTest() {
		counterUtility.insertWord("add");
		counterUtility.insertWord("ADD");
		counterUtility.insertWord("this");
		counterUtility.insertWord("word");
		counterUtility.insertWord("symphony");
		List<Words> words = counterUtility.getAllWords();
		assertEquals(5, words.size());
	}
}
