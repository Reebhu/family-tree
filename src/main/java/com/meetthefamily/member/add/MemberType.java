package com.meetthefamily.member.add;

import java.util.Map;

import com.meetthefamily.family.Member;

/**
 * Specifies the type of (@link Member} being added.
 * 
 * @author Reebhu
 */
public interface MemberType
{
	/**
	 * The method to add member to family tree.
	 * 
	 * @param instruction
	 *        the intruction according to which the members are to be added.
	 * @param familyMap
	 *        The map containing the family members.
	 * @return the newly added member.
	 */
	Member add(String instruction, Map<String, Member> familyMap);
}
