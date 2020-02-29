package com.meetthefamily.family;

import java.io.IOException;
import java.util.Map;

import com.meetthefamily.Constants.Errors;
import com.meetthefamily.Constants.Instructions;
import com.meetthefamily.Constants.Response;
import com.meetthefamily.member.relation.RelationRetriver;
import com.meetthefamily.verifier.VerifyException;

public class FamilyTree
{
	/**
	 * @param familyMap
	 * @param input
	 * @throws IOException
	 */
	public static String processFamilyTree(final Map<String, Member> familyMap, String input)
	{

		final String string[] = input.split(" ");
		final Instructions instruction = Enum.valueOf(Instructions.class, string[0]);
		switch (instruction)
		{
		// Adding spouse is taken care of by the MemberTypeFactory, So we don't
		// specifically need to handle it here.
		case ADD_SPOUSE:
		case ADD_CHILD:

			try
			{
				if (Family.addMember(familyMap, input, instruction))
				{
					return Response.CHILD_ADDITION_SUCCEEDED.name();
				}
				else
				{
					return Errors.PERSON_NOT_FOUND.name();
				}
			}
			catch (final VerifyException e)
			{
				return Errors.CHILD_ADDITION_FAILED.name();
			}
		case GET_RELATIONSHIP:
			try
			{
				return RelationRetriver.getRelationship(familyMap, input).trim();
			}
			catch (final VerifyException e)
			{
				return Response.NONE.name();
			}
		default:
			return Errors.INVALID_INPUT.name();
		}
	}
}
