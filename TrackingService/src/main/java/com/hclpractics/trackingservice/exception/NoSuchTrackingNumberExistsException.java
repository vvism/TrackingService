package com.hclpractics.trackingservice.exception;

public class NoSuchTrackingNumberExistsException extends RuntimeException {

	private String message;

	public NoSuchTrackingNumberExistsException() {}

	public NoSuchTrackingNumberExistsException(String msg)
	    {
	        super(msg);
	        this.message = msg;
	    }
}
