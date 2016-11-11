package com.neomind.samples;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@RunWith(JUnit4.class)
public class ArraysTest
{
	// processamento paralelo
	@Test
	public void doTest()
	{
		long[] arrayOfLong = new long[20000];
		Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(1000000));
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.println(i + " "));

		Arrays.parallelSort(arrayOfLong);
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.println(i + " "));

		Assert.assertTrue(true);
	}
}
