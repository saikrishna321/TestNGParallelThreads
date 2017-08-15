package com.test.classes;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

/**
 * Appium Manager - this class contains method to start and stops appium server
 * To execute the tests from eclipse, you need to set PATH as
 * /usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin in run configuration
 */
public class AppiumServer {
    public  AppiumDriver<MobileElement> driver;
	// CommandPrompt cp = new CommandPrompt();
	AvailabelPorts ap = new AvailabelPorts();
	AppiumDriverLocalService appiumDriverLocalService;
    CommandPrompt cp = new CommandPrompt();
    public AppiumServiceBuilder builder = new AppiumServiceBuilder();
	/**
	 * start appium with default arguments
	 */
	public void startDefaultAppium() throws Exception {
		// cp.runCommand("appium --session-override");
		Thread.sleep(5000);
	}

	/**
	 * start appium with auto generated ports : appium port, chrome port,
	 * bootstrap port and device UDID
	 */

	@SuppressWarnings("static-access")
	public AppiumServiceBuilder appiumServer() throws Exception {
		builder.
				withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")).
				withArgument(GeneralServerFlag.LOG_LEVEL, "info")
				.usingAnyFreePort().withLogFile(new File("Log" + Thread.currentThread().getName() +
				Thread.currentThread().getId()));
		/* and so on */
		;

		appiumDriverLocalService = builder.build();
		appiumDriverLocalService.start();
		System.out.println("Server has been started");
		//appiumDriverLocalService.getStdOut();	
		System.out.println(appiumDriverLocalService.isRunning());
		System.out.println(builder);
		return builder;

	}


	public int getAppiumUrl() {
		return appiumDriverLocalService.getUrl().getPort();
	}

	public void destroyAppiumNode() {
		appiumDriverLocalService.stop();
	}

}
