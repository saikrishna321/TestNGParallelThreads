package com.test.classes;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before Classes");
	}
	
	
	@AfterClass
	public void afterClass(){
		System.out.println("After Classes");
	}


}
