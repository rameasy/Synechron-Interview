package com.synechron.example.interview.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class Words.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Words implements Comparable<Words> {

	/** The word. */
	private String word;

	/** The count. */
	private Long count;

	/**
	 * Compare to.
	 *
	 * @param words the words
	 * @return the int
	 */
	@Override
	public int compareTo(Words words) {
		return this.word.compareTo(words.word);
	}
}
