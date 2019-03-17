package com.magrathea.twitterchallenge.factory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import twitter4j.Twitter;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TwitterComponentFactory.class)
public class TwitterComponentFactoryTest {

	@Autowired
	private AbstractFactoryBean<Twitter> factory;
	
	@Test
	public void instanceShouldNotBeSingleton() throws Exception {
		final Twitter twitterOne = this.factory.getObject();
		final Twitter twitterTwo = this.factory.getObject();
		
		Assert.assertTrue(twitterOne == twitterTwo);
	}
	
}
