package com.synechron.example.interview.counter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.synechron.example.interview.exceptions.InvalidWordException;
import com.synechron.example.interview.exceptions.WordCounterException;
import com.synechron.example.interview.model.Words;
import com.synechron.example.interview.translator.Translator;

/**
 * The Class CounterUtility.
 */
@Component
public class CounterUtility {

	/** The translator. */
	private Translator translator;

	/**
	 * Instantiates a new counter utility.
	 */
	public CounterUtility() {
		this.translator = Translator.getInstance();
	}

	/** The words map. */
	private Map<String, Words> wordsMap = new TreeMap<>();

	/**
	 * This method inserts the received word and increments the number of insertion
	 * of respective word.
	 *
	 * @param word the word
	 */
	public String insertWord(String word) {
		word = getTranslatedWord(word);
		Words words = wordsMap.get(word);
		if (words == null) {
			wordsMap.put(word, new Words(word, 1L));
		} else {
			words.setCount(words.getCount() + 1);
			wordsMap.put(word, words);
		}
		return "Word added successfully";
	}

	/**
	 * This method returns the number of times a word has been inserted.
	 *
	 * @param word the word
	 * @return the count
	 */
	public Words getCount(String word) {

		word = getTranslatedWord(word);
		if (word == null) {
			throw new WordCounterException("Unable to find the word");
		}
		Words words = wordsMap.get(word);
		if (words == null) {
			throw new WordCounterException("Unable to find the word");
		} else {
			return words;
		}
	}

	/**
	 * This method returns all the words and its insertion count.
	 *
	 * @return the all words
	 */
	public List<Words> getAllWords() {
		return wordsMap.values().stream().collect(Collectors.toList());
	}

	/**
	 * This method validates the received word.
	 *
	 * @param word the word
	 * @return true, if successful
	 */
	private void validateWord(String word) {
		if (word == null || word.trim().length() == 0) {
			throw new InvalidWordException("Not a valid word");
		}
		if (!word.matches("^[a-zA-Z]*$")) {
			throw new InvalidWordException("Word contains non-alphabetic character/s");
		}
	}

	/**
	 * This method translates the received word and returns the equivalent English
	 * word. This method is implemented with Facade design pattern.
	 *
	 * @param word the word
	 * @return the translated word
	 */
	private String getTranslatedWord(String word) {
		validateWord(word);
		return translator.translate(word.trim().toLowerCase());
	}
}
