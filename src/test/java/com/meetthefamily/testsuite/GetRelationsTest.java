package com.meetthefamily.testsuite;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.meetthefamily.family.Family;
import com.meetthefamily.family.FamilyTree;
import com.meetthefamily.family.Member;

public class GetRelationsTest
{
	@Rule
	public ExpectedException expected = ExpectedException.none();

	private Map<String, Member> familyMap;

	@Before
	public void setUpfamily()
	{
		final Family family = new Family();
		familyMap = family.createFamily();
	}

	@Test
	public void test_GetRelation_PersonNotFound()
	{
		final String input = "GET_RELATIONSHIP Pjali Son";
		assertEquals("PERSON_NOT_FOUND", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_GetRelation_PaternalUncle()
	{
		final String input = "GET_RELATIONSHIP Kriya Paternal-Uncle";
		assertEquals("Asva", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_GetRelation_PaternalAunt()
	{
		final String input = "GET_RELATIONSHIP Vritha Paternal-Aunt";
		assertEquals("Satya", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_GetRelation_MaternalUncle()
	{
		final String input = "GET_RELATIONSHIP Yodhan Maternal-Uncle";
		assertEquals("Vritha", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_GetRelation_MaternalAunt()
	{
		final String input = "GET_RELATIONSHIP Yodhan Maternal-Aunt";
		assertEquals("Tritha", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_GetRelation_Daughter()
	{
		final String input = "GET_RELATIONSHIP Lika Daughter";
		assertEquals("Vila Chika", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_GetRelation_Son()
	{
		final String input = "GET_RELATIONSHIP Anga Son";
		assertEquals("Chit Ish Vich Aras", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_GetRelation_BrotherInLaw()
	{
		final String input = "GET_RELATIONSHIP Jaya Brother-In-Law";
		assertEquals("Vritha", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_GetRelation_SisterInLaw()
	{
		final String input = "GET_RELATIONSHIP Atya Sister-In-Law";
		assertEquals("Satvy Krpi", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_GetRelation_Siblings()
	{
		final String input = "GET_RELATIONSHIP Vyas Siblings";
		assertEquals("Asva Atya", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_GetRelation_NONE()
	{
		final String input = "GET_RELATIONSHIP Lavnya Maternal-Aunt ";
		assertEquals("NONE", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_GetRelation_NONE_()
	{
		final String input = "GET_RELATIONSHIP Vasa Maternal-Aunt ";
		assertEquals("NONE", FamilyTree.processFamilyTree(familyMap, input));
	}

}