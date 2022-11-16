package testClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Grouping {

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("After Test");
	}
	
	@Test(groups = {"login", "smoke"})
	public void tc001_login_valido() {
		System.out.println("tc001_login_valido");
	}
	
	@Test(groups = {"login"})
	public void tc002_login_invalido() {
		System.out.println("tc002_login_invalido");
	}
	
	@Test(groups = {"cadastro", "smoke"})
	public void tc003_login_cadastro_valido() {
		System.out.println("tc003_login_cadastro_valido");
	}
	
	@Test(groups = {"cadastro"})
	public void tc004_login_cadastro_invalido() {
		System.out.println("tc004_login_cadastro_invalido");
	}

	@Test(groups = {"cadastro", "mrc"})
	public void tc005_login_cadastro_duplicado() {
		System.out.println("tc005_login_cadastro_duplicado");
	}

}
