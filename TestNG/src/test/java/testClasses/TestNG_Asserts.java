package testClasses;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appCode.GFTapplication;

public class TestNG_Asserts {

	GFTapplication obj = new GFTapplication();

	@Test
	public void testMethod1() {
		System.out.println("@Test -> testMethod1");
		int currentResult = obj.sum(1, 2);
		int expectResult = 5;
		System.out.println(currentResult);

		assertEquals(currentResult, expectResult);

	}

	@Test
	public void testMethod2() {

		SoftAssert sa = new SoftAssert();
		
		System.out.println("@Test -> testMethod1");
		
		int currentResult = obj.sum(2, 2);
		int expectResult = 5;
		//assertEquals(currentResult, expectResult);
		System.out.println("Terminei o primeiro teste");
		sa.assertEquals(currentResult, expectResult);
		
		int currentResult2 = obj.sum(3, 3);
		int expectResult2 = 6;
		sa.assertEquals(currentResult2, expectResult2);
		System.out.println("Terminei o segundo teste");
		
		sa.assertAll();
	}

	@Test
	public void testMethod3() {
		System.out.println("@Test -> testMethod1");
		int currentResult = obj.sum(3, 2);
		int expectResult = 5;
		System.out.println(currentResult);

		assertEquals(currentResult, expectResult);

	}

}
