package com.meetthefamily.testsuite;

import java.net.URL;

import org.junit.Test;

import com.meetthefamily.main.Solution;

/**
 * @author Reebhu
 */
public class SolutionTest
{

	/**
	 * Tests the programs according to given file as input. Written just to check
	 * the overall functionality.
	 */
	@Test
	public void test()
	{
		final URL inputURL = SolutionTest.class.getResource("TestInput.txt");
		final String path = inputURL.getPath().replace("%20", " ");
		final String args[] = {
				path
		};
		Solution.main(args);

	}

}
