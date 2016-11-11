package com.neomind.samples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@RunWith(JUnit4.class)
public class ConcurrentTest
{
	ExecutorService executor = Executors.newFixedThreadPool(2);

	// atomic
	private static AtomicInteger atomicInt = new AtomicInteger(0);

	@Test
	public void doTest() throws Exception
	{
		IntStream.range(0, 30).forEach(i ->
		{
			Runnable task = () -> atomicInt.updateAndGet(n -> n + 2);
			executor.submit(task);
		});

		stop(executor);

		System.out.format("Update: %d\n", atomicInt.get());

	}

	@Test
	public void doTest2() throws Exception
	{

		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 30).forEach(i -> executor.submit(ConcurrentTest::incrementSync));

		stop(executor);

		System.out.println(count);

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////

	private static int count = 0;

	private static void incrementSync()
	{
		synchronized(ConcurrentTest.class)
		{
			count = count + 1;
		}
	}

	public void stop(ExecutorService executor)
	{
		try
		{
			executor.shutdown();
			executor.awaitTermination(60, TimeUnit.SECONDS);
		}
		catch(InterruptedException e)
		{
			System.err.println("termination interrupted");
		}
		finally
		{
			if(!executor.isTerminated())
			{
				System.err.println("killing non-finished tasks");
			}
			executor.shutdownNow();
		}
	}

	public void sleep(int seconds)
	{
		try
		{
			TimeUnit.SECONDS.sleep(seconds);
		}
		catch(InterruptedException e)
		{
			throw new IllegalStateException(e);
		}
	}
}

