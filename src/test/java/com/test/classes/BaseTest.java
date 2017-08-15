package com.test.classes;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.URL;
import java.util.HashMap;

public class BaseTest extends BaseTestServer{
	WebDriver driver;
	 CommandPrompt cp = new CommandPrompt();

	 @BeforeSuite
	 public void startSrver() throws Exception {
		// setUp();
	 }

	@BeforeClass
	public void beforeClass() throws Exception {
		System.out.println("Before Classes"+ "Command line hello world. Thread id = " + Thread.currentThread().getId());

	}
	
	
	@AfterSuite
	public void afterClass(){
		System.out.println("After Classes"+ "Command line hello world. Thread id = " + Thread.currentThread().getId());
		//tearDown();
	}
	
	@BeforeClass
	public void beforeMethod() throws Exception{
		String[] devices={"B20B9EEA-3F18-42D4-9606-E863D0EAACE6","B605A2CF-C5D3-43B5-8DAB-9F0171698D66"};
		int thread_device_count = Integer.valueOf(Thread.currentThread().getName().split("-")[2]) - 1;
		System.out.println("Setting device" + devices[thread_device_count]);
		HashMap<String,String> deviceName = new HashMap<String, String>();
		deviceName.put("B20B9EEA-3F18-42D4-9606-E863D0EAACE6","My-iphone7");
		deviceName.put("B605A2CF-C5D3-43B5-8DAB-9F0171698D66","My1-iphone7");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "iOS");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability(MobileCapabilityType.UDID,devices[thread_device_count]);
		capabilities.setCapability("app",System.getProperty("user.dir") + "/WordPress.zip");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName.get(devices[thread_device_count]));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
		capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT,new AvailabelPorts().getPort());
		capabilities.setCapability(IOSMobileCapabilityType.USE_PREBUILT_WDA,true);
		//capabilities.setCapability("appActivity", "com.android2.calculator3.Calculator");
		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:" + "4723" + "/wd/hub"), capabilities);
		System.out.println("BeforeMethod "+ "Command line hello world. Thread id = " + Thread.currentThread().getId());


	}
	
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("AfterMethod "+ "Command line hello world. Thread id = " + Thread.currentThread().getId());

	}

}
