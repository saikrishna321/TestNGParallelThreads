package com.test.classes;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoClassWithManyMethodsTest extends BaseTest{
	
	 @Test
     public void methodOne_1() throws InterruptedException {
         //Thread.sleep(20000);
         System.err.println("This is methodOneDemoClass"+ "Command line hello world. Thread id = " + Thread.currentThread().getId());

     }

     @Test
     public void methodTwo_2() {
         System.err.println("This is methodTwoDemoClass"+ "Command line hello world. Thread id = " + Thread.currentThread().getId());
     }
 

}
