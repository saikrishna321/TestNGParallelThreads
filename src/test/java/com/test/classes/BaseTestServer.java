package com.test.classes;

public class BaseTestServer {
   
	public static AppiumServer server = new AppiumServer();

	public void setUp() throws Exception{
		server.appiumServer();
	}
	

	public void tearDown(){
		server.destroyAppiumNode();
	}

	public int getUrl(){
		return server.getAppiumUrl();
	}
	
	
}
