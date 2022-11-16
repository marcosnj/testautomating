package testClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_BeforeMethod {

	@Test
	public void testMethod1() {
		System.out.println("@Test -> testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("@Test -> testMEthod2");
	}
	
	@Test
	public void tmrc() {
		System.out.println("Eitaaaaa");
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
