package regression;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseTest.BaseTestSuite;

public class TestNG_TestClass3 extends BaseTestSuite {

	@Test
	public void testMethod1() {
		System.out.println("testMethod1 - CLASS3");
	}

	@Test
	public void testMethod2() {
		System.out.println("testMEthod2 - CLASS3");
	}

	@Test
	public void tmrc() {
		System.out.println("Eitaaaaa - CLASS3");
	}

	@BeforeMethod
	public void beforeMethod1() {
		System.out.println("Before");
	}

	@AfterMethod
	public void afterMethod2() {
		System.out.println("After");
	}

}
