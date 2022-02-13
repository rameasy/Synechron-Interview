package com.synechron.example.interview.translator.languages;

import java.util.HashMap;
import java.util.Map;

/**
 * A factory class for creating LanguageTranslator objects.
 */
public class LanguageTranslatorFactory {

	/** The Constant translatorMap. */
	private static final Map<String, LanguageTranslator> translatorMap = new HashMap<>();

	
	private LanguageTranslatorFactory() {
	}
	/**
	 * Gets the respective language translator object based on the language passed.
	 * This method implements flyweight design pattern which utilizes the memory and
	 * returns the same language translator.
	 *
	 * @param language the language
	 * @return the language translator
	 */
	public static LanguageTranslator getLanguageTranslator(String language) {
		LanguageTranslator translator = translatorMap.get(language);
		if (translator == null) {
			if ("es".equalsIgnoreCase(language)) {
				translator = new SpanishTranslator();
				translatorMap.put(language, translator);
				return translator;
			} else if ("fr".equalsIgnoreCase(language)) {
				translator = new FrenchTranslator();
				translatorMap.put(language, translator);
				return translator;
			} else if ("de".equalsIgnoreCase(language)) {
				translator = new GermanTranslator();
				translatorMap.put(language, translator);
				return translator;
			}
		} else {
			return translator;
		}
		throw new IllegalArgumentException("No such Translator");
	}
}
