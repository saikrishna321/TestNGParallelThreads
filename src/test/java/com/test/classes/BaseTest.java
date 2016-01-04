package com.test.classes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseTestServer{
	WebDriver driver;
	 CommandPrompt cp = new CommandPrompt();
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before Classes"+ "Command line hello world. Thread id = " + Thread.currentThread().getId());
	}
	
	
	@AfterClass
	public void afterClass(){
		
		System.out.println("After Classes"+ "Command line hello world. Thread id = " + Thread.currentThread().getId());
	}
	
	@BeforeMethod
	public void beforeMethod() throws Exception{
		setUp();
		System.out.println("BeforeMethod "+ "Command line hello world. Thread id = " + Thread.currentThread().getId());

	}
	
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("AfterMethod "+ "Command line hello world. Thread id = " + Thread.currentThread().getId());
		tearDown();
	}
	
	@AfterSuite()
	public void finalEnd() throws InterruptedException, IOException{
		//cp.runCommand("killall -9 node");
	}
}
