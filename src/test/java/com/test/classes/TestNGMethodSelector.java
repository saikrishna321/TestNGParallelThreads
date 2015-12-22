package com.test.classes;

import org.testng.annotations.Test;
public class TestNGMethodSelector extends BaseTest{


	@Test
	public static void methodOne() {
		System.err.println("This is methodOneTestNGClass");
	}

	@Test
	public void methodTwo() {
		System.err.println("This is methodTwoTestNGClass");
	}

	@Test
	public void methodThree() {
		System.err.println("This is methodThreeTestNGClass");
	}

	@Test
	public void methodFour() {
		System.err.println("This is methodFourTestNGClass");
	}

	@Test
	public void methodFive() {
		System.err.println("This is methodFiveTestNGClass");
	}

	@Test
	public void methodSix() {
		System.err.println("This is methodSixTestNGClass");
	}

	@Test
	public void methodSeven() {
		System.err.println("This is methodSevenTestNGClass");
	}
}
