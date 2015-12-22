package com.test.classes;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.google.common.collect.Lists;

public class MethodRunner {
	List<Class> testcases = new ArrayList<Class>();
	List<Thread> threads = new ArrayList<Thread>();
	@Test
	public void runMethodParallelAppium() throws Exception {

		// getClassPackage("com.test.parallel");

		Collection<URL> urls = ClasspathHelper.forPackage("com.test.classes");
		Iterator<URL> iter = urls.iterator();
		URL url = iter.next();
		urls.clear();
		URL newUrl = new URL(url.toString() + "com/test/classes/");
		List<URL> newUrls = Lists.newArrayList(newUrl);
		Reflections reflections = new Reflections(
				new ConfigurationBuilder().setUrls(newUrls).setScanners(new MethodAnnotationsScanner()));
		Set<Method> resources = reflections.getMethodsAnnotatedWith(org.testng.annotations.Test.class);

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		for (final Method met : resources) {
			executorService.submit(new Runnable() {

				public void run() {
					// TODO Auto-generated method stub
					if (met.getDeclaringClass().getSimpleName().contains("Test")) {
						System.out.println("*****CurrentRunningThread" + Thread.currentThread().getName()
								+ met.getDeclaringClass() + "***MethodName****" + met.getName().toString());
						runMethodParallel(met.getDeclaringClass(), met.getName().toString());
					}

				}
			});
		}
		
		executorService.shutdown();
		try {
			executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finally complete");

	}

	@SuppressWarnings("rawtypes")
	public static void runMethodParallel(Class classes, String method) {
		System.out.println("running test: " + classes.getSimpleName() + ":" + method);
		TestNG testNG = new TestNG();
		testNG.setVerbose(2);
		XmlSuite suite = new XmlSuite();
		suite.setName("TestNG Forum");
		XmlTest test = new XmlTest(suite);
		test.setName("TestNG Test");
		XmlClass clazz = new XmlClass();
		// Since DemoClassWithManyMethods is a nested class, we have to use "$"
		// symbol, else we could have just used
		// getCanonicalName() alone

		// clazz.setName(MethodRunner.class.getCanonicalName() + "$" +
		// classes.getSimpleName());
		clazz.setName(classes.getCanonicalName());
		// clazz.setClass(classes);
		XmlInclude include = new XmlInclude(method);

		include.setXmlClass(clazz);
		clazz.setIncludedMethods(Arrays.asList(include));
		test.setXmlClasses(Arrays.asList(clazz));
		testNG.setXmlSuites(Arrays.asList(suite));
		testNG.run();
	}
}
