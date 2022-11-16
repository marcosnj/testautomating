package basics;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RA_SpecBuilder {

	RequestSpecBuilder requestBuilder;
	static RequestSpecification requestSpec;

	ResponseSpecBuilder responseBuilder;
	static ResponseSpecification responseSpec;
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException {
		// Setar a URL Basica
		//RestAssured.baseURI = "https://reqres.in";

		// Setar path parameter padrao
		//RestAssured.basePath = "/api";
		
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		
		requestBuilder = new RequestSpecBuilder();
		requestBuilder.setBaseUri("https://reqres.in");
		requestBuilder.setBasePath("/api");
		requestBuilder.addHeader("Content-Type", "application/json");
		requestBuilder.addFilter(RequestLoggingFilter.logRequestTo(log));
		requestBuilder.addFilter(ResponseLoggingFilter.logResponseTo(log));
		requestSpec = requestBuilder.build();
		
		responseBuilder = new ResponseSpecBuilder();
		responseBuilder.expectStatusCode(201);
		responseSpec = responseBuilder.build();
		
	}

	@Test
	public void getResponseCode() {
		given()
			.spec(requestSpec)
			.pathParam("pparam", "users")
			.body("{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"leader\"\r\n"
					+ "}")
		.when()
			.post("/{pparam}")
		.then()
			.assertThat()
			.spec(responseSpec);
	}

}