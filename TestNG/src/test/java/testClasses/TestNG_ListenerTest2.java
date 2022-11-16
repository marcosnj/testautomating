package testClasses;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseTest.BaseTestSuite;
import listeners.CustomListener1;

//@Listeners(CustomListener1.class)
public class TestNG_ListenerTest2 {
//public class TestNG_ListenerTest1 extends BaseTestSuite{
	@Test
	public void testMethod1() {
		System.out.println("- testMethod1");
		assertTrue(true);
	}
	
	@Test
	public void testMethod2() {
		System.out.println("- testMEthod2");
		assertTrue(false);
	}
		
}
