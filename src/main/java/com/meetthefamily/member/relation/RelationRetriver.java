package com.meetthefamily.member.relation;

import java.util.List;
import java.util.Map;

import com.meetthefamily.Constants.Errors;
import com.meetthefamily.Constants.Response;
import com.meetthefamily.family.Member;

public class RelationRetriver
{
	/**
	 * Processes and returns the Realtionship.
	 *
	 * @param familyMap
	 *        The Map containing the whole family members.
	 * @param input
	 *        The input instruction to fetch the realtionship.
	 */
	public static String getRelationship(Map<String, Member> familyMap, String input)
	{
		final Relationship relation = new Relationship(familyMap);
		final List<String> outputList = relation.processInput(input);
		String out = "";
		if (outputList == null)
		{
			return Errors.PERSON_NOT_FOUND.name();
		}
		else if (outputList.isEmpty())
		{
			return Response.NONE.name();
		}
		else
		{
			for (final String output : outputList)
			{
				if (output != null && !output.isEmpty())
				{
					out = out + output + " ";
				}
			}
		}
		return out;
	}
}
