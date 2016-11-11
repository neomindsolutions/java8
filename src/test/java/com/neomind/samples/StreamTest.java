package com.neomind.samples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RunWith(JUnit4.class)
public class StreamTest
{

	@Test
	public void streamFullSample()
	{
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted()
				.forEach(System.out::println);
	}

	@Test
	public void streamFullParallelSample()
	{
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList.parallelStream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted()
				.forEach(System.out::println);
	}

	@Test
	public void findFirst()
	{
		Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println);  // a1
	}

	@Test
	public void findFirstFfPresent()
	{
		Stream.of("a1", "a2", "a3").findFirst().ifPresent(System.out::println);  // a1
	}

	@Test
	public void intStream()
	{
		IntStream.range(1, 4).forEach(System.out::println);
	}

	@Test
	public void streamFilter()
	{
		Stream.of("d2", "a2", "b1", "b3", "c").filter(s ->
		{
			System.out.println("filter: " + s);
			return true;
		});
	}

	/////////////////////////////////////////////////////////////////////////
	final Collection<Task> tasks = Arrays
			.asList(new Task(Status.OPEN, 5), new Task(Status.OPEN, 13), new Task(Status.CLOSED, 8));

	/////////////////////////////////////////////////////////////////////////

	@Test
	public void doTestStreamComplex()
	{
		final long totalPointsOfOpenTasks = tasks.stream()
				.filter(task -> task.getStatus() == Status.OPEN).mapToInt(Task::getPoints).sum();

		System.out.println("Total points: " + totalPointsOfOpenTasks);

	}

	@Test
	public void doTestStreamComplex2()
	{
		final double totalPoints = tasks.stream().parallel()
				.map(task -> task.getPoints()) // or map( Task::getPoints )
				.reduce(0, Integer::sum);
		System.out.println("Total points (all tasks): " + totalPoints);
	}

	@Test
	public void doTestStreamComplex3()
	{
		final Map<Status, List<Task>> map = tasks.stream()
				.collect(Collectors.groupingBy(Task::getStatus));
		System.out.println(map);
	}

	private enum Status
	{
		OPEN, CLOSED
	}

	private static final class Task
	{
		private final Status status;
		private final Integer points;

		Task(final Status status, final Integer points)
		{
			this.status = status;
			this.points = points;
		}

		public Integer getPoints()
		{
			return points;
		}

		public Status getStatus()
		{
			return status;
		}

		@Override
		public String toString()
		{
			return String.format("[%s, %d]", status, points);
		}
	}

}
