package com.test.classes;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class DemoClassWithManyMethodsTest extends BaseTest{
	
	 @Test
     public void methodOne_1() throws InterruptedException {
         Thread.sleep(2000);
         System.err.println("This is methodOneDemoClass"+ "Command line hello world. Thread id = " + Thread.currentThread().getId());

     }

     @Test
     public void methodTwo_2() {
         System.err.println("This is methodTwoDemoClass"+ "Command line hello world. Thread id = " + Thread.currentThread().getId());
     }
 

}
