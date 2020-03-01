package com.meetthefamily.verifier;

/**
 * Custom Exception.
 * 
 * @author Reebu Mukherjee
 */
public class VerifyException extends RuntimeException
{

	private static final long serialVersionUID = 3165086772828594868L;

	public VerifyException(String message)
	{
		super(message);
	}

}
