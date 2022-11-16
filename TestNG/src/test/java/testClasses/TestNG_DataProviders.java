package testClasses;

import org.testng.annotations.Test;

public class TestNG_DataProviders{
	
	@Test(dataProvider = "input", dataProviderClass = TestDataFactory.class)
	public void testMethod1(String usuario, String senha) {
		System.out.println("Usuario: " + usuario);
		System.out.println("Senha: " + senha);
	}
	
	@Test(dataProvider = "excelp", dataProviderClass = TestDataFactory.class)
	public void testMethod2(String batata, String Arroz) {
		System.out.println("Parametro 1: " + batata);
		System.out.println("Parametro 2: " + Arroz);
	}
	
	@Test(dataProvider = "jfaker", dataProviderClass = TestDataFactory.class)
	public void testMethod3(String nome, String fruta, String hp) {
		System.out.println("P1: " + nome);
		System.out.println("P2: " + fruta);
		System.out.println("P3: " + hp);
		System.out.println("");
	}
	
}
