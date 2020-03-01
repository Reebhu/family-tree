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

public class AddMembersTest
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
	public void test_ADD_CHILD_MotherNotFound()
	{
		final String input = "ADD_CHILD Pjali Srutak Male";
		assertEquals("PERSON_NOT_FOUND", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_ADD_CHILD_MotherIsMale()
	{
		final String input = "ADD_CHILD Asva Vani Female ";
		assertEquals("CHILD_ADDITION_FAILED", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_ADD_CHILD_MotherIsSingle()
	{
		final String input = "ADD_CHILD Lavnya Kirit Male";
		assertEquals("CHILD_ADDITION_FAILED", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_ADD_CHILD_success()
	{
		final String input = "ADD_CHILD Satya Ketu Male";
		assertEquals("CHILD_ADDITION_SUCCEEDED", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_ADD_CHILD_InvalidGender()
	{
		expected.expect(IllegalArgumentException.class);
		final String input = "ADD_CHILD Satya Ketu SOME";
		FamilyTree.processFamilyTree(familyMap, input);
	}

	@Test
	public void test_ADD_CHILD_nullGender()
	{
		expected.expect(ArrayIndexOutOfBoundsException.class);
		final String input = "ADD_CHILD Name";
		FamilyTree.processFamilyTree(familyMap, input);
	}

	@Test
	public void test_ADD_SPOUSE_InvalidGender()
	{
		expected.expect(IllegalArgumentException.class);
		final String input = "ADD_SPOUSE Vich Lika Female";
		FamilyTree.processFamilyTree(familyMap, input);
	}

	@Test
	public void test_Add_SPOUSE_success()
	{
		final String input = "ADD_SPOUSE Lavnya Raj Male";
		assertEquals("CHILD_ADDITION_SUCCEEDED", FamilyTree.processFamilyTree(familyMap, input));
	}

	@Test
	public void test_Add_SPOUSE_SposeNotFound()
	{
		final String input = "ADD_SPOUSE Lavya Raj Male";
		assertEquals("PERSON_NOT_FOUND", FamilyTree.processFamilyTree(familyMap, input));
	}
}
