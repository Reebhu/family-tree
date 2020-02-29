package com.meetthefamily.Constants;

public enum Relation
{
	PaternalUncle("Paternal-Uncle"),
	MaternalUncle("Maternal-Uncle"),
	MaternalAunt("Maternal-Aunt"),
	PaternalAunt("Paternal-Aunt"),
	SisterInLaw("Sister-In-Law"),
	BrotherInLaw("Brother-In-Law"),
	Son("Son"),
	Daughter("Daughter"),
	Siblings("Siblings"),
	Unknown("Unknown");

	private String name;

	Relation(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public static Relation fromString(String text)
	{
		for (final Relation realtion : Relation.values())
		{
			if (realtion.name.equalsIgnoreCase(text))
			{
				return realtion;
			}
		}
		return Unknown;
	}
}
