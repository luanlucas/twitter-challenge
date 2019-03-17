package com.magrathea.twitterchallenge.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magrathea.twitterchallenge.model.TwitterMessage;
import com.magrathea.twitterchallenge.service.TwitterMessageService;

@RestController
@RequestMapping("/v1/messages")
public class TwitterMessageController {

	@Autowired
	private TwitterMessageService twitterMessageService;
	
	@GetMapping
	public ResponseEntity<Set<TwitterMessage>> getMessages() {
		return ResponseEntity.ok(this.twitterMessageService.fetchMessages());
	}
	
}