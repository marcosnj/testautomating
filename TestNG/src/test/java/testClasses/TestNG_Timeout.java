package testClasses;

import org.testng.annotations.Test;

public class TestNG_Timeout {

	@Test(timeOut = 1000) //em milisegundos
	public void testMethod1() throws InterruptedException {
		System.out.println("@Test -> testMethod1");
		Thread.sleep(2000);
		
		//try {
		//	Thread.sleep(2000);
		//} catch (InterruptedException) {
		//	// TODO: handle exception
		//	System.out.println("Errouuuuuuuuuuuuuuuuu");
		//}
	}
	
	@Test(timeOut = 4000)
	public void testMethod2() {
		System.out.println("@Test -> testMEthod2");
	}
	
	@Test
	public void mrc() {
		System.out.println("Eitaaaaa");
	}
}
