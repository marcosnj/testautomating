package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

public class RA_Logging {

	@BeforeMethod
	public void setUp() {
		// Setar a URL Basica
		RestAssured.baseURI = "https://reqres.in";

		// Setar path parameter padrao
		RestAssured.basePath = "/api";
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(); //seta o log padrão
	}

	@Test
	public void useLogging() {
		given() //request - log da requisicao
			//.log().all()
			//.log().params()
			//.log().body()
			//.log().method()
			//.log().ifValidationFails() //usar preferencialmente
			.pathParam("pparam", "users")
			.queryParam("page", 2)
			.header("Connection", "keep-alive")
			.body("{"
					+ "'pedro': 'pedro'"
					+ "}")
		.when() //chamada
			.get("/{pparam}")
		.then() //response
			//.log().all()
			//.log().body()
			//.log().ifError() //so loga se der erro..  usar preferencialmente
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
	
}