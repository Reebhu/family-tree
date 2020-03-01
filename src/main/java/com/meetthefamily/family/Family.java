package com.meetthefamily.family;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import com.meetthefamily.Constants.Instructions;
import com.meetthefamily.main.Solution;
import com.meetthefamily.member.add.MemberTypeFactory;

public class Family
{
	private static final String INPUT_FILE = "InitialInput.txt";

	/**
	 * Initialize the family tree by population the members.
	 *
	 * @return The non-null and non empty Map of family members with thier name as
	 *         key.
	 */
	public Map<String, Member> createFamily()
	{

		final Map<String, Member> familyMap = new LinkedHashMap<>();
		final InputStream inputStream = Solution.class.getResourceAsStream(INPUT_FILE);
		final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		try
		{
			String input;

			while ((input = reader.readLine()) != null)
			{
				final String string[] = input.split(" ");
				final Instructions instruction = Enum.valueOf(Instructions.class, string[0]);
				addMember(familyMap, input, instruction);
			}
		}
		// CLOVER:OFF
		catch (final IOException e)
		{
			System.out.println("Exception:" + e.getMessage());
		}
		// CLOVER:ON
		return familyMap;
	}

	/**
	 * Adds the member to family tree according to given instruction.
	 *
	 * @param familyMap
	 *        The Map containing the members of the family.
	 * @param instruction
	 *        The instruction specifying the type of member being added to the tree.
	 * @return
	 */
	public static boolean addMember(Map<String, Member> familyMap, String input, Instructions instruction)
	{
		final Member member = MemberTypeFactory.getFactory().add(input, familyMap, instruction);
		if (member != null)
		{
			familyMap.put(member.getName(), member);
			return true;
		}
		else
		{
			return false;
		}

	}
}
