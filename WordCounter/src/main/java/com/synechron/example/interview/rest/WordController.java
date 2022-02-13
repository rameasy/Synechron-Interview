package com.synechron.example.interview.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.example.interview.counter.CounterUtility;
import com.synechron.example.interview.exceptions.InvalidWordException;
import com.synechron.example.interview.model.Words;
import com.synechron.example.interview.pojo.WordCounterResponseObject;

/**
 * The Class WordController.
 */
@RequestMapping("/word-counter/rest")
@RestController
public class WordController {

	/** The counter utility. */
	@Autowired
	CounterUtility counterUtility;

	/**
	 * This method exposes the API to insert the word.
	 *
	 * @param word the word
	 * @return the response entity
	 */
	@PutMapping(path = "/v0.1/insert/{word}")
	ResponseEntity<WordCounterResponseObject> insertWord(@PathVariable String word) {
		WordCounterResponseObject wordCounterResponseObject = new WordCounterResponseObject();
		String message = null;
		try {
			message = counterUtility.insertWord(word);
		} catch (InvalidWordException iwe) {
			message = iwe.getMessage();
		}
		wordCounterResponseObject.setMessage(message);
		return new ResponseEntity<>(wordCounterResponseObject, HttpStatus.OK);
	}

	/**
	 * This method exposes the API to retrieve the count of the given word.
	 *
	 * @param word the word
	 * @return the word count
	 */
	@GetMapping(path = "/v0.1/count-word")
	ResponseEntity<WordCounterResponseObject> getWordCount(@RequestParam String word) {
		WordCounterResponseObject wordCounterResponseObject = new WordCounterResponseObject();
		String message = null;
		Words words = null;
		try {
			words = counterUtility.getCount(word);
			wordCounterResponseObject.setWord(words);
		} catch (RuntimeException iwe) {
			message = iwe.getMessage();
		}
		wordCounterResponseObject.setMessage(message);
		return new ResponseEntity<>(wordCounterResponseObject, HttpStatus.OK);
	}

	/**
	 * This method exposes the API to list all the words.
	 *
	 * @return the all words
	 */
	@GetMapping(path = "/v0.1/listAllWords")
	ResponseEntity<WordCounterResponseObject> getAllWords() {
		WordCounterResponseObject wordCounterResponseObject = new WordCounterResponseObject();
		String message = null;
		List<Words> wordsList = null;
		try {
			wordsList = counterUtility.getAllWords();
			wordCounterResponseObject.setWordsList(wordsList);
		} catch (InvalidWordException iwe) {
			message = iwe.getMessage();
		}
		wordCounterResponseObject.setMessage(message);
		return new ResponseEntity<>(wordCounterResponseObject, HttpStatus.OK);
	}
}
