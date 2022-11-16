package basics;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RA_ResponseExtraction {

	@BeforeMethod
	public void setUp() {
		// Setar a URL Basica
		RestAssured.baseURI = "https://reqres.in";

		// Setar path parameter padrao
		RestAssured.basePath = "/api";
	}

	@Test
	
	public void getResponseData() {
		
		Response resposta = 		
		given()
			.pathParam("pparam", "users")
			.queryParam("page", 2)
		.when()
			.get("/{pparam}")
		.then()
			.assertThat()
			.statusCode(200)
			.extract().response();
		
		resposta.prettyPrint();
	}

}