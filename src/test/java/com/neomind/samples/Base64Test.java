package com.neomind.samples;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RunWith(JUnit4.class)
public class Base64Test
{

	@Test
	public void doTest()
	{
		final String text = "Testedobase64";
		final String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
		System.out.println(encoded);

		final String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
		System.out.println(decoded);

		Assert.assertEquals(text, decoded);

	}
}
