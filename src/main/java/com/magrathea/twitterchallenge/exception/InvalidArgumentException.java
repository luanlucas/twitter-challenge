package com.magrathea.twitterchallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class InvalidArgumentException extends RuntimeException {

	private static final long serialVersionUID = -7836420453249043742L;
	
	public InvalidArgumentException(final String message) {
		super(message);
	}

}
