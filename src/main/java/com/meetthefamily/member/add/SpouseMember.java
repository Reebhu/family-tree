package com.meetthefamily.member.add;

import java.util.Map;

import com.meetthefamily.Constants.Gender;
import com.meetthefamily.family.Member;

/**
 * The class to represent spouse {@link MemberType}.
 *
 * @author Reebu Mukherjee
 */
public class SpouseMember implements MemberType
{

	@Override
	public Member add(String instruction, Map<String, Member> familyMap)
	{
		final String[] splitString = instruction.split(" ");
		final String spouseName = splitString[1];
		final String name = splitString[2];
		final Gender gender = Gender.valueOf(splitString[3].toUpperCase());

		final Member spouse = familyMap.get(spouseName);
		if (spouse != null && spouse.getSpouse().isEmpty())
		{
			final Member newMember = Member.Builder.create().withName(name).withSpouse(spouse).withGender(gender)
					.build();
			spouse.getSpouse().add(newMember);

			return newMember;
		}
		else if (spouse != null && !spouse.getSpouse().isEmpty())
		{
			throw new IllegalArgumentException();
		}
		return null;
	}

}
