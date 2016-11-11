package com.neomind.samples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

@RunWith(JUnit4.class)
public class AnnotationsTest
{
	// novidade na criação de anotações agora possibilitadno anotar variaveis locais, tipos genericos, super classes
	// etc
	@Test
	public void doTest()
	{
		final Holder< String > holder = new @NonEmpty Holder< String >();
		@NonEmpty Collection< @NonEmpty String > strings = new ArrayList<>();

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.TYPE_USE, ElementType.TYPE_PARAMETER })
	public @interface NonEmpty
	{
	}

	public static class Holder<@NonEmpty T> extends @NonEmpty Object
	{
		public void method() throws @NonEmpty Exception
		{
		}
	}

}
