package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

public class RA_BodyValidation {

	@BeforeMethod
	public void setUp() {
		// Setar a URL Basica
		RestAssured.baseURI = "https://reqres.in";

		// Setar path parameter padrao
		RestAssured.basePath = "/api";
	}

	@Test
	public void validationBody() {
		given()
			.pathParam("pparam", "users")
			.queryParam("page", 2)
		.when()
			.get("/{pparam}")
		.then()
			.assertThat()
			.statusCode(200)
			.and().body("data[2].first_name", equalTo("Tobias"))
			.and().body("data", hasSize(6))
			.and().body("data.first_name", hasItems("Lindsay"))
			.and().body("data.id", hasItems(7,8,9,10,11,12))
			.and().body("data[0].avatar", anything())
			.and().body("data[0].avatar", containsString("image"))
			.and().body("data[3].email", startsWith("byron"));
		
	}

	//por mais que tenha erro ele nao para o teste
	@Test
	public void validationBodyWithSoftAssert() {
		given()
			.pathParam("pparam", "users")
			.queryParam("page", 2)
		.when()
			.get("/{pparam}")
		.then()
			.assertThat()
			.statusCode(200)
			.and().body("total", equalTo(12),
						"data[2].first_name", equalTo("Tobias"),
						"data", hasSize(6),
						"data.id", hasItems(7,8,9));
		
	}

	
}