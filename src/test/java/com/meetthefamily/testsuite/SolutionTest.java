package com.meetthefamily.testsuite;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.meetthefamily.main.Solution;

/**
 * @author Reebhu
 */
public class SolutionTest
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
		final String expected = "PERSON_NOT_FOUND\r\n" + "PERSON_NOT_FOUND\r\n" + "CHILD_ADDITION_FAILED\r\n"
				+ "CHILD_ADDITION_SUCCEEDED\r\n" + "Asva Ketu\r\n" + "Vritha\r\n" + "Amba Lika Chitra\r\n" + "NONE\r\n"
				+ "CHILD_ADDITION_SUCCEEDED\r\n" + "Aria\r\n" + "Vritha\r\n" + "NONE\r\n" + "Vritha\r\n"
				+ "Vila Chika\r\n" + "PERSON_NOT_FOUND\r\n" + "INVALID_INPUT\r\n" + "CHILD_ADDITION_FAILED\r\n"
				+ "PERSON_NOT_FOUND\r\n" + "INVALID_INPUT\r\n" + "Tritha\r\n" + "Vyan\r\n" + "PERSON_NOT_FOUND\r\n"
				+ "CHILD_ADDITION_SUCCEEDED\r\n" + "Aria\r\n" + "Jnki Ahit\r\n" + "NONE\r\n";
		assertEquals(expected, outContent.toString());

	}

}
