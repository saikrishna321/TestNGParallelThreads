package com.test.classes;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

public class Method_TestNG {
	public static void main(String[] args) {
		runViaClasses();
		//runViaXmlClassConcept();
	}
	
	public static void runViaXmlClassConcept(){
		TestNG testng = new TestNG();
		XmlSuite suite = new XmlSuite();
		XmlTest test = new XmlTest(suite);
		XmlClass clazz = new XmlClass();
		clazz.setClass(TestNGMethodSelector.class);
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(clazz);
		test.setClasses(classes);
		List<XmlTest> tests = new ArrayList<XmlTest>();
		tests.add(test);
		suite.setTests(tests);
		testng.setParallel(ParallelMode.METHODS);
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		testng.setXmlSuites(suites);
		testng.run();
	}
	
	public static void runViaClasses(){
		Class[] classes = new Class[]{TestNGMethodSelector.class,DemoClassWithManyMethodsTest.class};
		TestNG testng = new TestNG();
		testng.setParallel(ParallelMode.METHODS);
		testng.setThreadCount(2);
		testng.setTestClasses(classes);
		testng.run();
	}

}
