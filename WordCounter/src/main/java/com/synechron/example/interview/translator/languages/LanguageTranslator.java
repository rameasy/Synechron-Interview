package com.synechron.example.interview.translator.languages;

/**
 * The Interface LanguageTranslator.
 */
public interface LanguageTranslator {

	/**
	 * This method identifies the equivalent English word for the received word.
	 *
	 * @param word the word
	 * @return the string
	 */
	public abstract String identifyEquivalentWord(String word);
}
