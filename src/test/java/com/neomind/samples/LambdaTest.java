package com.neomind.samples;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RunWith(JUnit4.class)
public class LambdaTest
{

	List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

	@Test
	public void oldJava()
	{
		Collections.sort(names, new Comparator<String>()
		{
			@Override
			public int compare(String a, String b)
			{
				return b.compareTo(a);
			}
		});

		// show infos
		for(String name : names)
		{
			System.out.println(name);
		}

		Assert.assertNotNull(names);
	}

	@Test
	public void newJava()
	{
		Collections.sort(names, (String a, String b) ->
		{
			return b.compareTo(a);
		});

		// show infos
		for(String name : names)
		{
			System.out.println(name);
		}

		Assert.assertNotNull(names);
	}
}
