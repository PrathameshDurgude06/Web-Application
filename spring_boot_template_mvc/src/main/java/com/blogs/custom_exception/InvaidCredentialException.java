package com.blogs.custom_exception;

@SuppressWarnings("serial")
public class InvaidCredentialException extends RuntimeException {
	public InvaidCredentialException(String mesg) {
		super(mesg);
	}

}
