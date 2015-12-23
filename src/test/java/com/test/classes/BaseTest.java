package com.test.classes;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseTestServer{
	
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before Classes"+ "Command line hello world. Thread id = " + Thread.currentThread().getName());
	}
	
	
	@AfterClass
	public void afterClass(){
		System.out.println("After Classes"+ "Command line hello world. Thread id = " + Thread.currentThread().getName());
	}
	
	@BeforeMethod
	public void beforeMethod() throws Exception{
		System.out.println("BeforeMethod "+ "Command line hello world. Thread id = " + Thread.currentThread().getName());
		setUp();
	}
	
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("AfterMethod "+ "Command line hello world. Thread id = " + Thread.currentThread().getName());
		tearDown();
	}
}
