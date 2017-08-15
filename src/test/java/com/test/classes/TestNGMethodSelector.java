package com.test.classes;

import org.testng.annotations.Test;

public class TestNGMethodSelector extends BaseTest {

	@Test
	public static void methodOne() throws InterruptedException {
		Thread.sleep(2000);
		System.err.println("*******This is methodOneTestNGClass*******" + "Command line hello world. Thread id = "
				+ Thread.currentThread().getId());
	}

	@Test
	public void methodTwo() {
		System.err.println("This is methodTwoTestNGClass" + "Command line hello world. Thread id = "
				+ Thread.currentThread().getId());
	}

	@Test
	public void methodThree() {
		System.out.println("This is methodThreeTestNGClass" + "Command line hello world. Thread id = "
				+ Thread.currentThread().getId());
	}

	@Test
	public void methodFour() {
		System.out.println("This is methodFourTestNGClass" + "Command line hello world. Thread id = "
				+ Thread.currentThread().getId());
	}

	@Test
	public void methodFive() {
		System.out.println("This is methodFiveTestNGClass" + "Command line hello world. Thread id = "
				+ Thread.currentThread().getId());
	}

	@Test
	public void methodSix() {
		System.out.println("This is methodSixTestNGClass" + "Command line hello world. Thread id = "
				+ Thread.currentThread().getId());
	}

	@Test
	public void methodSeven() {
		System.out.println("This is methodSevenTestNGClass" + "Command line hello world. Thread id = "
				+ Thread.currentThread().getId());
	}
}
