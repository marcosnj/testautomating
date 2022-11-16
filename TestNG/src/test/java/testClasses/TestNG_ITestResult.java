package testClasses;

import static org.testng.Assert.assertTrue;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNG_ITestResult {

	@Test
	public void testMethod1() {
		System.out.println("@Test -> testMethod1");
		assertTrue(true);
	}

	@Test
	public void testMethod2() {
		System.out.println("@Test -> testMEthod2");
		assertTrue(false);
	}

	@Test
	public void mrc() {
		System.out.println("Eitaaaaa");
		assertTrue(true);
	}
	
	@Test
	public void test10() {
		System.out.println("test10");
		assertTrue(false);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult testResult) {
		if(testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println("Faiou meserengo: " + testResult.getMethod().getMethodName());
		} else if (testResult.getStatus() == ITestResult.SUCCESS) {
			System.out.println("Passssssssouuuuuuuu: " + testResult.getMethod().getMethodName());
		}
		
		System.out.println("afterMethod: " + testResult.getMethod().getMethodName());
	}
}
