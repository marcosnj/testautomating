package basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
//crtl + shift + o - arruma as importações

public class RA_Timout {

	@BeforeMethod
	public void setUp() {
		// Setar a URL Basica
		RestAssured.baseURI = "https://reqres.in";

		// Setar path parameter padrao
		RestAssured.basePath = "/api";
	}

	@Test
	public void validateResponseTime() {
		given()
			.pathParam("pparam", "users")
			.queryParam("page", 2)
		.when()
			.get("/{pparam}")
		.then()
			.assertThat()
			.statusCode(200)
			.and().body("total", equalTo(12),
					"per_page", equalTo(6))
			.and().time(lessThan(2000L), TimeUnit.MILLISECONDS); //mais comum
			//.and().time(lessThan(300L), TimeUnit.MILLISECONDS); //mais comum
			//.and().time(lessThan(1L), TimeUnit.SECONDS);
	}

}