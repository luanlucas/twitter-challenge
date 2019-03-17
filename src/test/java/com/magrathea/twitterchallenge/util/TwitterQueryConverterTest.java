package com.magrathea.twitterchallenge.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.junit.Assert;
import org.junit.Test;

import twitter4j.Query;

public class TwitterQueryConverterTest {

	private static final String KEYWORD_ONE = "#test1";

	private static final String KEYWORD_TWO = "#test2";
	
	private static final String KEYWORD_THREE = "#test3";
	
	private static final String EXPECTED_QUERY = "#test1 OR #test2 OR #test3";
	
	@Test
	public void queryShouldBeEmpty() {
		final Query query = TwitterQueryConverter.convertWithOrClause(new ArrayList<>());
		
		Assert.assertEquals(Strings.EMPTY, query.getQuery());
	}
	
	@Test
	public void queryShouldContainOrClause() {
		final List<String> keywords = Arrays.asList(KEYWORD_ONE, KEYWORD_TWO, KEYWORD_THREE);
		
		final Query query = TwitterQueryConverter.convertWithOrClause(keywords);
		
		Assert.assertEquals(EXPECTED_QUERY, query.getQuery());
	}
	
}
