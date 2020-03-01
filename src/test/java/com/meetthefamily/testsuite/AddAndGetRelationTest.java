package com.meetthefamily.testsuite;

import java.net.URL;

import org.junit.Test;

import com.meetthefamily.main.Solution;

public class AddAndGetRelationTest
{
	@Test
	public void test_input1()
	{
		final URL inputURL = SolutionTest.class.getResource("TestInput1.txt");
		final String path = inputURL.getPath().replace("%20", " ");
		final String args[] = {
				path
		};
		Solution.main(args);
	}

	@Test
	public void test_input2()
	{
		final URL inputURL = SolutionTest.class.getResource("TestInput2.txt");
		final String path = inputURL.getPath().replace("%20", " ");
		final String args[] = {
				path
		};
		Solution.main(args);
	}

	@Test
	public void test_input3()
	{

		final URL inputURL = SolutionTest.class.getResource("TestInput3.txt");
		final String path = inputURL.getPath().replace("%20", " ");
		final String args[] = {
				path
		};
		Solution.main(args);
	}
}
