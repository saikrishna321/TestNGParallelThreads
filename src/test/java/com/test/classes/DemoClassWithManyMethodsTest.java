package com.test.classes;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.testng.annotations.Test;

public class DemoClassWithManyMethodsTest extends BaseTest{
		
	 @Test
     public void methodOne_1() throws InterruptedException {
         System.err.println("This is methodOneDemoClass");
         Thread.sleep(2000);
     }

     @Test
     public void methodTwo_2() {
         System.err.println("This is methodTwoDemoClass");
     }
 

}
