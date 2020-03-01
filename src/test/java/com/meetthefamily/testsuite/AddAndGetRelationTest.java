package com.meetthefamily.testsuite;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.meetthefamily.main.Solution;

public class AddAndGetRelationTest
{
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	private final PrintStream originalOut = System.out;

	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams()
	{
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams()
	{
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	@Test
	public void test_input1()
	{
		final URL inputURL = SolutionTest.class.getResource("TestInput1.txt");
		final String path = inputURL.getPath().replace("%20", " ");
		final String args[] = {
				path
		};
		Solution.main(args);
		assertEquals("CHILD_ADDITION_SUCCEEDED\r\n" + "Aria\r\n" + "Jnki Ahit\r\n", outContent.toString());
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
		assertEquals("CHILD_ADDITION_SUCCEEDED\r\n" + "Asva Ketu\r\n" + "Vyas Ketu\r\n", outContent.toString());
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
		assertEquals("Atya\r\n" + "NONE\r\n" + "PERSON_NOT_FOUND\r\n", outContent.toString());
	}
}
