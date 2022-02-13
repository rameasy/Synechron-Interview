package com.synechron.example.interview.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.synechron.example.interview.model.Words;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class WordCounterResponseObject.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
public class WordCounterResponseObject {
	/** The words list. */
	@JsonProperty("words")
	private List<Words> wordsList;

	/** The word. */
	@JsonProperty("word")
	private Words word;

	/** The message. */
	@JsonProperty("message")
	private String message;
}
