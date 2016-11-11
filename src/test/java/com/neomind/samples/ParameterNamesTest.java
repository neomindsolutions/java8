package com.neomind.samples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@RunWith(JUnit4.class)
public class ParameterNamesTest {

    @Test
    public void test() throws Exception {
        methodWithParams(null);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    public void methodWithParams(String[] args) throws Exception {
        Method method = ParameterNamesTest.class.getMethod("methodWithParams", String[].class);
        for (final Parameter parameter : method.getParameters()) {
            System.out.println("Parameter: " + parameter.getName());
        }
    }

}
