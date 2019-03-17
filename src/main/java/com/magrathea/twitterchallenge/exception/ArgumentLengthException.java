package com.magrathea.twitterchallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class ArgumentLengthException extends RuntimeException {

	private static final long serialVersionUID = -4379633758198817033L;

	public ArgumentLengthException(final String message) {
		super(message);
	}
	
}
