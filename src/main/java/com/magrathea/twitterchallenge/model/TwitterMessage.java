package com.magrathea.twitterchallenge.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TwitterMessage {

	private String message;
	
	private String author;
	
	private Date createdAt;
}
