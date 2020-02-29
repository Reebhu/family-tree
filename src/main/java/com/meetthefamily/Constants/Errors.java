package com.meetthefamily.Constants;

public enum Errors
{
	CHILD_ADDITION_FAILED
	{
		@Override
		public String toString()
		{
			return "CHILD_ADDITION_FAILED";
		}
	},
	INVALID_INPUT
	{
		@Override
		public String toString()
		{
			return "INVALID_INPUT";
		}
	},
	PERSON_NOT_FOUND
	{
		@Override
		public String toString()
		{
			return "PERSON_NOT_FOUND";
		}
	}
}
