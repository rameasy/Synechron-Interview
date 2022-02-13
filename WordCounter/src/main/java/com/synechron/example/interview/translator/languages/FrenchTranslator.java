package com.synechron.example.interview.translator.languages;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * The Class FrenchTranslator that translates the French words to English.
 */
public class FrenchTranslator implements LanguageTranslator {

	/** The French to English map. */
	private static Map<String, String> frenchToEnglishMap;

	static {
		Map<String, String> map = new TreeMap<>();
		map.put("fleur", "flower");
		map.put("mot", "word");
		frenchToEnglishMap = Collections.unmodifiableMap(map);
	}

	/**
	 * This method identifies the equivalent English word for the received French
	 * word.
	 *
	 * @param word the word
	 * @return the string
	 */
	@Override
	public String identifyEquivalentWord(String word) {
		return frenchToEnglishMap.get(word);
	}
}
