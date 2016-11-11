package com.neomind.samples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.annotation.*;

@RunWith(JUnit4.class)
public class AnnotationsRepeatingTest
{

	// possibilita usar a mesma anotação repetidamente // ex @Filter
	@Test
	public void repeatingTest()
	{
		for(Filter filter : Filterable.class.getAnnotationsByType(Filter.class))
		{
			System.out.println(filter.value());
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Filters
	{
		Filter[] value();
	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(Filters.class)
	public @interface Filter
	{
		String value();
	}

	@Filter("filter1")
	@Filter("filter2")
	public interface Filterable
	{
	}

}
