package com.synechron.example.interview.translator;

import java.util.List;
import java.util.Objects;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;
import com.synechron.example.interview.exceptions.InvalidWordException;
import com.synechron.example.interview.translator.languages.LanguageTranslator;
import com.synechron.example.interview.translator.languages.LanguageTranslatorFactory;

/**
 * The Class Translator translates the words. This class implements Singleton
 * design pattern where the objects will be created only once.
 * 
 */
public class Translator {

	static {
		DetectLanguage.apiKey = "1c5292ef585d1a67c0ead44ce87f3bf7";
	}
	/**
	 * Instantiates a new Translator.
	 */
	private Translator() {
	}

	/**
	 * The Class TranslatorHolder.
	 */
	private static class TranslatorHolder {

		/** The Constant translator. */
		public static final Translator translator = new Translator();
	}

	/**
	 * Gets the single instance of Translator.
	 *
	 * @return single instance of Translator
	 */
	public static Translator getInstance() {
		return TranslatorHolder.translator;
	}

	/**
	 * This method helps to translate the received other language word to English
	 * word.
	 *
	 * @param word the word
	 * @return the string
	 */
	public String translate(String word) {
		List<Result> results = null;
		try {
			results = DetectLanguage.detect(word);
		} catch (APIError e) {
			e.printStackTrace();
			throw new InvalidWordException(e.getMessage());
		}
		LanguageTranslator translator = null;
		if (Objects.nonNull(results) && !results.isEmpty()) {
			for (Result result : results) {
				if ("es".equals(result.language) || "de".equals(result.language) || "fr".equals(result.language)) {
					translator = LanguageTranslatorFactory.getLanguageTranslator(result.language);
					break;
				}
			}
		}
		if (Objects.nonNull(translator)) {
			word = translator.identifyEquivalentWord(word);
		}
		return word;
	}
}
