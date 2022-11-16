package testClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Parameters {

	@BeforeClass
	@Parameters({"browser", "platform"})
	public void setUp(String pedro, String cebola) {
		System.out.println("Parametro 1: " + pedro);
		System.out.println("Parametro 2: " + cebola);
		
		//exemplo
		//Drive Factory
		if(pedro.equals("firefox")) {
			//abre o firefox
		} else if(pedro.equals("chrome")) {
			//abre o chrome
		} else if(pedro.equals("safari")) {
			// abre o safari
		}
			
	}
	
	
	@Test
	@Parameters({"response"})
	public void testMethod1(String resposta) {
		System.out.println("@Test -> testMethod1:");
		System.out.println("Parametro: " + resposta);
	}
	
	@Test
	public void testMethod2() {
		System.out.println("@Test -> testMEthod2");
	}
	
	@Test
	public void mrc() {
		System.out.println("Eitaaaaa");
	}
}
