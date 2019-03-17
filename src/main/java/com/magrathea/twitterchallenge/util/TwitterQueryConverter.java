package com.magrathea.twitterchallenge.util;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.util.Strings;

import lombok.experimental.UtilityClass;
import twitter4j.Query;

@UtilityClass
public class TwitterQueryConverter {

	private static final String OR_CLAUSE = " OR ";
	
	public Query convertWithOrClause(final List<String> keywords) {
		Objects.requireNonNull(keywords, "Key words must not be null.");
		
		final String query = keywords
									.stream()
									.reduce((result, keyword) -> result + OR_CLAUSE + keyword)
									.orElse(Strings.EMPTY);
		
		return new Query(query);
	}
	
}
