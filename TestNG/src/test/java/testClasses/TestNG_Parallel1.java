package testClasses;

import org.testng.annotations.Test;

public class TestNG_Parallel1 {

	@Test
	public void testMethod1() {
		System.out.println("testParallel1 - testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("testParallel1 - testMethod2");
	}
	
	@Test
	public void testMethod3() {
		System.out.println("testParallel1 - testMethod3");
	}
	
	@Test
	public void testMethod4() {
		System.out.println("testParallel1 - testMethod4");
	}
}
