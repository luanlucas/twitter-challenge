package com.magrathea.twitterchallenge.util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.magrathea.twitterchallenge.model.TwitterMessage;

import lombok.experimental.UtilityClass;
import twitter4j.Status;

@UtilityClass
public class TwitterMessageConverter {
	
	public List<TwitterMessage> convert(final List<Status> status) {
		Objects.requireNonNull(status, "Status list must not be null.");
		
		return status
					.stream()
					.map(TwitterMessageConverter::convert)
					.collect(Collectors.toList());
	}
	
	public TwitterMessage convert(final Status status) {
		Objects.requireNonNull(status, "Status must not be null.");
		
		return TwitterMessage
					.builder()
					.author(status.getUser().getName())
					.createdAt(status.getCreatedAt())
					.message(status.getText())
					.build();
	}
}
