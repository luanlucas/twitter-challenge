package com.magrathea.twitterchallenge.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.magrathea.twitterchallenge.model.TwitterMessage;
import com.magrathea.twitterchallenge.util.TwitterMessageConverter;
import com.magrathea.twitterchallenge.util.TwitterQueryConverter;

import lombok.RequiredArgsConstructor;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@RequiredArgsConstructor
@Service
public class TwitterMessageService {

	private final TrackingService trackingService;
	
	private final Twitter twitter;
	
	public Set<TwitterMessage> fetchMessages() {
		final Set<TwitterMessage> twitterMessages = new LinkedHashSet<>();
		Query query = this.createSearchQuery();
		QueryResult queryResult;
		
		try {
			do {
				queryResult = this.twitter.search(query);
				this.addTwitterMessages(twitterMessages, queryResult);
				query = queryResult.nextQuery();
			} while (Objects.nonNull(query));
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
		return twitterMessages;
	}

	private Query createSearchQuery() {
		final List<String> keywords = this.trackingService.findKeywords();
		return TwitterQueryConverter.convertWithOrClause(keywords);
	}
	
	private void addTwitterMessages(final Set<TwitterMessage> twitterMessages, final QueryResult queryResult) {
		final List<Status> tweets = queryResult.getTweets();
		final List<TwitterMessage> messages = TwitterMessageConverter.convert(tweets);
		twitterMessages.addAll(messages);
	}
	
}
