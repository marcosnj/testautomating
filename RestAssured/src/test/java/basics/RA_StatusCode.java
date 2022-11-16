package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RA_StatusCode {

	@BeforeMethod
	public void setUp() {
		// Setar a URL Basica
		RestAssured.baseURI = "https://reqres.in";

		// Setar path parameter padrao
		RestAssured.basePath = "/api";
	}

	@Test
	public void getResponseCode() {
		given()
			.pathParam("pparam", "users")
			.queryParam("page", 2)
		.when()
			.get("/{pparam}")
		.then()
			.assertThat()
			.statusCode(200);
	}

}