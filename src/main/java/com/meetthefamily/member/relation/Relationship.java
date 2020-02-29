package com.meetthefamily.member.relation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.meetthefamily.Constants.Gender;
import com.meetthefamily.Constants.Relation;
import com.meetthefamily.family.Member;
import com.meetthefamily.verifier.Verifier;

/**
 * The class to find relationship for given member.
 *
 * @author Reebhu
 */
public class Relationship
{
	private final Map<String, Member> familyMap;

	public Relationship(Map<String, Member> familyMap)
	{
		this.familyMap = familyMap;
	}

	private List<Member> getSiblings(Member member)
	{
		final List<Member> siblings = new ArrayList<>();
		final Member mother = member.getMother();
		if (mother == null)
		{
			return siblings;
		}
		for (final Map.Entry<String, Member> entry : familyMap.entrySet())
		{
			if (entry.getValue().getMother() == mother)
			{
				siblings.add(entry.getValue());
			}
		}
		siblings.remove(member);
		return siblings;
	}

	private List<String> getSiblingsName(Member member)
	{
		return memberToString(getSiblings(member));
	}

	private List<Member> getSisters(Member member)
	{
		final List<Member> sisters = getSiblings(member).stream().filter(sister -> Gender.FEMALE == sister.getGender())
				.collect(Collectors.toList());
		return sisters;
	}

	private List<Member> getBrothers(Member member)
	{
		final List<Member> brothers = getSiblings(member).stream().filter(brother -> Gender.MALE == brother.getGender())
				.collect(Collectors.toList());
		return brothers;
	}

	private List<String> getPaternalUncle(Member member)
	{
		final Member father = member.getFather();

		Verifier.verifyNotNull(father);

		return memberToString(getBrothers(father));
	}

	private List<String> getMaternalUncle(Member member)
	{
		final Member mother = member.getMother();

		Verifier.verifyNotNull(mother);

		return memberToString(getBrothers(mother));
	}

	private List<String> getPaternalAunt(Member member)
	{
		final Member father = member.getFather();

		Verifier.verifyNotNull(father);

		return memberToString(getSisters(father));
	}

	private List<String> getMaternalAunt(Member member)
	{
		final Member mother = member.getMother();

		Verifier.verifyNotNull(mother);

		return memberToString(getSisters(mother));
	}

	private List<String> getSisterInLaw(Member member)
	{
		final List<String> sisterInLaws = new ArrayList<>();
		if (!member.getSpouse().isEmpty())
		{
			final Member spouse = member.getSpouse().get(0);
			sisterInLaws.addAll(memberToString(getSisters(spouse)));
		}
		final List<Member> siblings = getBrothers(member);
		for (final Member sibling : siblings)
		{
			sisterInLaws.add(!sibling.getSpouse().isEmpty() ? sibling.getSpouse().get(0).getName() : null);
		}
		return sisterInLaws;
	}

	private List<String> getBrotherInLaw(Member member)
	{
		final List<String> brotherInLaws = new ArrayList<>();
		if (!member.getSpouse().isEmpty())
		{
			final Member spouse = member.getSpouse().get(0);
			brotherInLaws.addAll(memberToString(getBrothers(spouse)));
		}
		final List<Member> siblings = getSisters(member);
		for (final Member sibling : siblings)
		{
			brotherInLaws.add(!sibling.getSpouse().isEmpty() ? sibling.getSpouse().get(0).getName() : null);
		}
		return brotherInLaws;
	}

	private List<String> getSons(Member member)
	{
		return memberToString(member.getSons());
	}

	private List<String> getDaughters(Member member)
	{
		return memberToString(member.getDaugthers());
	}

	private List<String> memberToString(List<Member> members)
	{
		return members.stream().map(member -> member.getName()).collect(Collectors.toList());
	}

	/**
	 * The List of names of the member with given relationship.
	 *
	 * @param input
	 *        The given input to find the relationship.
	 * @return The list of name of the members according to the relationship
	 *         provided.
	 */
	public List<String> processInput(String input)
	{
		Verifier.verifyNotNull(input, "input:null");
		final String[] inputArray = input.split(" ");
		final Member member = familyMap.get(inputArray[1]);
		if (member == null)
		{
			return null;
		}
		final Relation relation = Relation.fromString(inputArray[2]);
		switch (relation)
		{
		case PaternalUncle:
			return getPaternalUncle(member);

		case MaternalUncle:
			return getMaternalUncle(member);

		case MaternalAunt:
			return getMaternalAunt(member);

		case PaternalAunt:
			return getPaternalAunt(member);

		case SisterInLaw:
			return getSisterInLaw(member);

		case BrotherInLaw:
			return getBrotherInLaw(member);

		case Son:
			return getSons(member);

		case Daughter:
			return getDaughters(member);

		case Siblings:
			return getSiblingsName(member);

		case Unknown:
			throw new IllegalArgumentException();
		default:
			return null;
		}
	}

}
