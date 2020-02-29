package com.meetthefamily.member.add;

import java.util.Map;

import com.meetthefamily.Constants.Instructions;
import com.meetthefamily.family.Member;

/**
 * Factory to add members according to the instructions.
 *
 * @author Reebu Mukherjee
 */
public class MemberTypeFactory
{
	/**
	 * Return the instance of MemberTypeFactory.
	 *
	 * @return
	 */
	public static MemberTypeFactory getFactory()
	{
		return new MemberTypeFactory();
	}

	/**
	 * Adds the members as suitable {@link MemberType}.
	 *
	 * @param instruction
	 *        The instruction specifying the type of member to add.
	 * @param familyMap
	 *        The Map containing the family members.
	 * @param instruction2
	 * @return The newly added {@link Member} to the tree.
	 */
	public Member add(String input, Map<String, Member> familyMap, Instructions instruction)
	{
		MemberType memberType = null;

		switch (instruction)
		{
		case ADD_CHILD:
			memberType = new ChildMember();
			break;
		case ADD_SPOUSE:
			memberType = new SpouseMember();
			break;
		case ADD_HEAD:
			memberType = new HeadMember();
			break;
		default:
			throw new IllegalArgumentException("Invalid Input");
		}
		return memberType.add(input, familyMap);
	}

	private MemberTypeFactory()
	{
	}
}
