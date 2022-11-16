package testClasses;

import org.testng.annotations.Test;

public class TestNG_Ignore {

	//@Test(dependsOnMethods = {"testMethod2"}) vai dar erro
	@Test
	public void testMethod1() {
		System.out.println("@Test -> testMethod1");
	}
	
	@Test(enabled = false)
	public void testMethod2() {
		System.out.println("@Test -> testMEthod2");
	}
	
	@Test
	public void mrc() {
		System.out.println("Eitaaaaa");
	}
}
