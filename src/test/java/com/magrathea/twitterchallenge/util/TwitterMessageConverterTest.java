package com.magrathea.twitterchallenge.util;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.magrathea.twitterchallenge.model.TwitterMessage;

import twitter4j.Status;
import twitter4j.User;

@RunWith(MockitoJUnitRunner.class)
public class TwitterMessageConverterTest {

	private static final String MESSAGE = "#test message test";
	
	private static final String AUTHOR = "author";
	
	private static final Date CREATED_AT = new Date();
	
	@Mock
	private Status status;
	
	@Mock
	private User user;
	
	@Test
	public void statusShouldBeConverted() {
		this.mockUser();
		this.mockStatus();
		
		final TwitterMessage twitterMessageDisplay = TwitterMessageConverter.convert(this.status);
		
		Assert.assertEquals(MESSAGE, twitterMessageDisplay.getMessage());
		Assert.assertEquals(AUTHOR, twitterMessageDisplay.getAuthor());
		Assert.assertEquals(CREATED_AT, twitterMessageDisplay.getCreatedAt());
	}
	
	private void mockUser() {
		Mockito.doReturn(AUTHOR).when(this.user).getName();
		Mockito.doReturn(this.user).when(this.status).getUser();
	}
	
	private void mockStatus() {
		Mockito.doReturn(MESSAGE).when(this.status).getText();
		Mockito.doReturn(CREATED_AT).when(this.status).getCreatedAt();
	}
	
}
