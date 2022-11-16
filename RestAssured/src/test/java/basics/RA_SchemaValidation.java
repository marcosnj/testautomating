package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;

public class RA_SchemaValidation {

	@BeforeMethod
	public void setUp() {
		// Setar a URL Basica
		RestAssured.baseURI = "https://reqres.in";

		// Setar path parameter padrao
		RestAssured.basePath = "/api";
	}

	@Test
	public void validateSchema() {
		
		File arquivo = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\schemas\\getUsersSchema.json");
		
		given()
			.pathParam("pparam", "users")
			.queryParam("page", 2)
		.when()
			.get("/{pparam}")
		.then()
			.assertThat()
			.statusCode(200)
			.body(matchesJsonSchema(arquivo));
	}

}