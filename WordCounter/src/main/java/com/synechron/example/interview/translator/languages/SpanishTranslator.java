package com.synechron.example.interview.translator.languages;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * The Class SpanishTranslator that translates the Spanish words to English.
 */
public class SpanishTranslator implements LanguageTranslator {

	/** The Spanish to English map. */
	private static Map<String, String> spanishToEnglishMap;

	static {
		Map<String, String> map = new TreeMap<>();
		map.put("flor", "flower");
		map.put("palabra", "word");
		spanishToEnglishMap = Collections.unmodifiableMap(map);
	}

	/**
	 * This method identifies the equivalent English word for the received Spanish
	 * word.
	 *
	 * @param word the word
	 * @return the string
	 */
	@Override
	public String identifyEquivalentWord(String word) {
		return spanishToEnglishMap.get(word);
	}
}
