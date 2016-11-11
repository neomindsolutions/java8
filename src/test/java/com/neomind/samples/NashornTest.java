package com.neomind.samples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

@RunWith(JUnit4.class)
public class NashornTest
{

	@Test
	public void doTest() throws Exception
	{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");

		System.out.println(engine.getClass().getName());
		System.out.println("Result:" + engine.eval("function f() { return 1; }; f() + 1;"));
	}
}
