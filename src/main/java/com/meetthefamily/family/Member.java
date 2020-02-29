package com.meetthefamily.family;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.meetthefamily.Constants.Gender;
import com.meetthefamily.verifier.Verifier;

/**
 * The class representing one family member.
 *
 * @author Reebu Mukherjee
 */
public class Member
{

	private String name;

	private Gender gender;

	private List<Member> sons = new ArrayList<>();

	private List<Member> daugthers = new ArrayList<>();

	private List<Member> spouse = new ArrayList<>();

	private Member father;

	private Member mother;

	/**
	 * @return the father
	 */
	public Member getFather()
	{
		return father;
	}

	/**
	 * @return the mother
	 */
	public Member getMother()
	{
		return mother;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender()
	{
		return gender;
	}

	/**
	 * @return the sons
	 */
	public List<Member> getSons()
	{
		return sons;
	}

	/**
	 * @return the daugthers
	 */
	public List<Member> getDaugthers()
	{

		return daugthers;
	}

	/**
	 * @return the spouse
	 */
	public List<Member> getSpouse()
	{
		return spouse;
	}

	@Override
	public String toString()
	{
		return "Member [" + (name != null ? "name=" + name + ", " : "")
				+ (!spouse.isEmpty() ? "spouse=" + spouse.get(0).getName() + " ," : "")
				+ (father != null ? "father=" + father.getName() + " ," : "")
				+ (mother != null ? "mother=" + mother.getName() + " ," : "")
				+ (gender != null ? "gender=" + gender : "") + "]";
	}

	private Member(Builder builder)
	{
		name = builder.name;
		gender = builder.gender;
		sons = builder.sons;
		daugthers = builder.daugthers;
		spouse = builder.spouse;
		mother = builder.mother;
		father = builder.father;
	}

	private Member()
	{
	}

	/**
	 * Builder class to create the member.
	 *
	 * @author Reebhu
	 */
	public static class Builder
	{
		private String name;

		private Gender gender;

		private List<Member> sons = new ArrayList<>();

		private List<Member> daugthers = new ArrayList<>();

		private List<Member> spouse = new ArrayList<>();

		private Member father;

		private Member mother;

		private Builder()
		{

		}

		public static Builder create()
		{
			return new Builder();
		}

		public Builder withFather(Member father)
		{
			Verifier.verifyNotNull(father, "father:null");
			this.father = father;
			return this;
		}

		public Builder withMother(Member mother)
		{
			Verifier.verifyNotNull(mother, "mother:null");
			this.mother = mother;
			return this;
		}

		public Builder withName(String name)
		{
			Verifier.verifyNotNull(name, "name:null");
			this.name = name;
			return this;
		}

		public Builder withGender(Gender gender)
		{
			Verifier.verifyNotNull(gender, "gender:null");

			this.gender = gender;
			return this;
		}

		public Builder withDaughters(List<Member> daugthers)
		{
			this.daugthers = daugthers;
			return this;
		}

		public Builder withSons(List<Member> sons)
		{
			this.sons = sons;
			return this;
		}

		public Builder withSpouse(List<Member> spouse)
		{
			this.spouse = spouse;
			return this;
		}

		public Builder withDaughters(Member... daugthers)
		{
			this.daugthers = Arrays.asList(daugthers);
			return this;
		}

		public Builder withSons(Member... sons)
		{
			this.sons = Arrays.asList(sons);
			return this;
		}

		public Builder withSpouse(Member... spouse)
		{
			this.spouse = Arrays.asList(spouse);
			return this;
		}

		public Member build()
		{
			return new Member(this);
		}

	}

}
