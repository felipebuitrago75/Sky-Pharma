package com.skypharma.skypharma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * Returns a 400 Bad Request HTTP status code.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DispatchStateException extends RuntimeException {
	public DispatchStateException(String message) {
		super(message);
	}
}
