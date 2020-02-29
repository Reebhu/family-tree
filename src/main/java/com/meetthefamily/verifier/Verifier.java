package com.meetthefamily.verifier;

/**
 * Class to verify constraints.
 *
 * @author Reebhu
 */
public class Verifier
{

	/**
	 * Verifies if the object is null or not.
	 *
	 * @param message
	 */
	public static void verifyNotNull(Object ob, String message)
	{
		if (ob == null)
		{
			throw new VerifyException(message);
		}
	}

	/**
	 * Verifies if the object is null or not.
	 */
	public static void verifyNotNull(Object ob)
	{
		if (ob == null)
		{
			throw new VerifyException("");
		}
	}

}
