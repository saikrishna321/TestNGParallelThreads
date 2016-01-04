package com.test.classes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestServer {
   
	AppiumServer server = new AppiumServer();

    String[] devices={"192.168.56.101:5555","192.168.56.102:5555"};
   

	public void setUp() throws Exception{
		//System.out.println("*****threadcount***"+ (Integer.valueOf(Thread.currentThread().getName().split("-")[3]) - 1));		
		//int thread_device_count = Integer.valueOf(Thread.currentThread().getName().split("-")[3]) - 1;		
		server.appiumServer("1212121");	
	}
	

	public void tearDown(){
		server.destroyAppiumNode();
	}
	
	
}
