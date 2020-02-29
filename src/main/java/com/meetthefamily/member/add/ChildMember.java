/**
 *
 */
package com.meetthefamily.member.add;

import java.util.Map;

import com.meetthefamily.Constants.Gender;
import com.meetthefamily.family.Member;
import com.meetthefamily.verifier.VerifyException;

/**
 * The class to specify {@link MemberType} as child and add it to the tree.
 *
 * @author Reebu Mukherjee
 */
public class ChildMember implements MemberType
{

	@Override
	public Member add(String instruction, Map<String, Member> familyMap)
	{
		final String[] splitString = instruction.split(" ");
		final String motherName = splitString[1];
		final String name = splitString[2];
		final Gender gender = Gender.valueOf(splitString[3].toUpperCase());

		final Member mother = familyMap.get(motherName);
		if (mother == null)
		{
			return null;
		}
		if (mother.getGender() == Gender.FEMALE && !mother.getSpouse().isEmpty())
		{
			final Member father = mother.getSpouse().get(0);
			final Member newMember = Member.Builder.create().withName(name).withMother(mother).withFather(father)
					.withGender(gender).build();
			if (gender == Gender.MALE)
			{
				mother.getSons().add(newMember);
				father.getSons().add(newMember);
			}
			else
			{
				mother.getDaugthers().add(newMember);
				father.getDaugthers().add(newMember);
			}
			return newMember;
		}
		throw new VerifyException("invalid mother");
	}
}
