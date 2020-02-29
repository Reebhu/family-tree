package com.meetthefamily.member.add;

import java.util.Map;

import com.meetthefamily.Constants.Gender;
import com.meetthefamily.family.Member;

public class HeadMember implements MemberType
{

	@Override
	public Member add(String instruction, Map<String, Member> familyMap)
	{
		final String name = instruction.split(" ")[1];
		final Gender gender = Gender.valueOf(instruction.split(" ")[2].toUpperCase());
		final Member head = Member.Builder.create().withName(name).withGender(gender).build();
		return head;
	}

}
