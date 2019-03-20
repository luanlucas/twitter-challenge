package com.magrathea.twitterchallenge.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.magrathea.twitterchallenge.entity.Tracking;
import com.magrathea.twitterchallenge.exception.InvalidArgumentException;
import com.magrathea.twitterchallenge.repository.TrackingRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TrackingService {

	private static final String TRACK_IDENTIFIER = "#";
	
	private final TrackingRepository trackingRepository;
	
	public Tracking follow(final String keyword) {
		this.validateTrackingKeyword(keyword);
		
		return this.save(keyword);
	}
	
	private Tracking save(final String keyword) {
		final Tracking tracking = new Tracking();
		tracking.setKeyword(keyword);
		
		return this.trackingRepository.save(tracking);
	}
	
	public void unfollow(final String keyword) {
		this.validateTrackingKeyword(keyword);
		
		this.delete(keyword);
	}

	private void delete(final String keyword) {
		Tracking tracking = this.trackingRepository.findByKeyword(keyword);
		
		this.trackingRepository.delete(tracking);
	}
	
	private void validateTrackingKeyword(final String keyword) {
		this.validateEmpty(keyword);
		this.validateIdentifier(keyword);
	}
	
	private void validateEmpty(final String keyword) {
		if (StringUtils.isEmpty(keyword)) {
			throw new InvalidArgumentException("Message must not be empty nor null.");
		}
	}
	
	private void validateIdentifier(final String keyword) {
		if (!StringUtils.startsWithIgnoreCase(keyword, TRACK_IDENTIFIER)) {
			throw new InvalidArgumentException("Message must start with #.");
		}
	}
	
	public List<String> findKeywords() {
		return this.trackingRepository.findKeywords();
	}
	
}
