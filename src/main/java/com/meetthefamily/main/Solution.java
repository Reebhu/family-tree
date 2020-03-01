package com.meetthefamily.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.meetthefamily.Constants.Errors;
import com.meetthefamily.family.Family;
import com.meetthefamily.family.FamilyTree;
import com.meetthefamily.family.Member;

/**
 * Class containing the main method.
 *
 * @author Reebu Mukherjee
 */
public class Solution
{

	/**
	 * Main method for execution of the program.
	 *
	 * @param args
	 *        Absolute file path of the input file.
	 */
	public static void main(String[] args)
	{
		final Family family = new Family();

		final Map<String, Member> familyMap = family.createFamily();
		final String filePath = args[0];
		final File file = new File(filePath);
		BufferedReader reader;
		try
		{
			reader = new BufferedReader(new FileReader(file));
			String input;
			while ((input = reader.readLine()) != null)
			{
				try
				{
					final String output = FamilyTree.processFamilyTree(familyMap, input);
					System.out.println(output);
				}
				// Since both of these exception will occur due to bad input data hence mapped
				// to this reason.
				catch (final IllegalArgumentException | ArrayIndexOutOfBoundsException e)
				{
					System.out.println(Errors.INVALID_INPUT);
				}

			}
		}
		catch (final IOException e)
		{
			System.out.println("Exception :" + e.getMessage());
		}
	}
}
