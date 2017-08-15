package com.test.classes;

import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class DemoClassWithManyMethodsTest extends  BaseTest {

    @Test
    public void methodOne_1() throws InterruptedException, MalformedURLException {
        System.out.println("------" + Thread.currentThread().getId());
        Thread.sleep(2000);
        System.err.println("This is methodOneDemoClass" + "Command line hello world. Thread id = " + Thread.currentThread().getId());

    }

}
