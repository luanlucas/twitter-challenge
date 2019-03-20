package com.magrathea.twitterchallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magrathea.twitterchallenge.entity.Tracking;
import com.magrathea.twitterchallenge.service.TrackingService;

@RestController
@RequestMapping("/v1/trackings")
public class TrackingController {

	@Autowired
	private TrackingService trackingService;
	
	// Trocar para post
	@GetMapping("/follow/{message}")
	public ResponseEntity<Tracking> save(@PathVariable final String message) {
		final Tracking tracking = this.trackingService.follow(message);
		
		return ResponseEntity.ok(tracking);
	}
	
	// Trocar para delete
	@GetMapping("/unfollow/{message}")
	public ResponseEntity<?> delete(@PathVariable final String message) {
		this.trackingService.unfollow(message);
		
		return ResponseEntity.ok().build();
	}
	
}
