package com.magrathea.twitterchallenge.factory;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@Log4j2
@Component
public class TwitterComponentFactory extends AbstractFactoryBean<Twitter> {

	@Override 
	public Class<?> getObjectType() {
		return Twitter.class;
	}

	@Override
	protected Twitter createInstance() throws Exception {
		final Twitter twitter = TwitterFactory.getSingleton();
		log.info("Creating twitter object {}.", twitter.hashCode());
		
		return twitter;
	}
	
	@Override
	protected void destroyInstance(final Twitter instance) throws Exception {
		log.info("Destroying twitter object {}.", instance.hashCode());
	}

}
