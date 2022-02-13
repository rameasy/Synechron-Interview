package com.synechron.example.interview.translator.languages;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * The Class GermanTranslator that translates the German words to English.
 */
public class GermanTranslator implements LanguageTranslator {

	/** The German to English map. */
	private static Map<String, String> germanToEnglishMap;

	static {
		Map<String, String> map = new TreeMap<>();
		map.put("blume", "flower");
		map.put("word", "word");
		germanToEnglishMap = Collections.unmodifiableMap(map);
	}

	/**
	 * This method identifies the equivalent English word for the received German
	 * word.
	 *
	 * @param word the word
	 * @return the string
	 */
	@Override
	public String identifyEquivalentWord(String word) {
		return germanToEnglishMap.get(word);
	}
}
