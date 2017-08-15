package com.test.classes;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Method_TestNG {
	public static void main(String[] args) {
		runViaClasses();
		//runViaXmlClassConcept();
		//runXML();
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
		testng.setThreadCount(3);
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		testng.setXmlSuites(suites);
		System.out.println(suite.toXml());
		//testng.run();
	}
	
	public static void runViaClasses(){
		Class[] classes = new Class[]{TestNGMethodSelector.class,DemoClassWithManyMethodsTest.class};
		TestNG testng = new TestNG();
		testng.setParallel(ParallelMode.METHODS);
		testng.setThreadCount(2);
		testng.setTestClasses(classes);
		testng.run();
	}
	
	public static void runXML(){
		TestNG testNG = new TestNG();
        testNG.setVerbose(2);
        testNG.setThreadCount(2);
        testNG.setParallel(ParallelMode.METHODS);
        XmlSuite suite = new XmlSuite();
        suite.setName("TestNG Forum");
        XmlTest test = new XmlTest(suite);
        test.setName("TestNG Test");
        XmlClass clazz = new XmlClass();
        //Since DemoClassWithManyMethods is a nested class, we have to use "$" symbol, else we could have just used
        //getCanonicalName() alone
        
        clazz.setName(DemoClassWithManyMethodsTest.class.getSimpleName());
        clazz.setClass(DemoClassWithManyMethodsTest.class);
        XmlInclude include = new XmlInclude("methodOne_1");
        include.setXmlClass(clazz);
        clazz.setIncludedMethods(Arrays.asList(include));
        test.setXmlClasses(Arrays.asList(clazz));
        testNG.setXmlSuites(Arrays.asList(suite));
        System.out.println(suite.toXml());

        testNG.run();
	}
	

}
