package basics;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basicsPOJO.POJO_Example;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class RA_Desserialization {

	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api";
	}
	
	@Test
	public void desJsonPat() {
		Response res = 
		given()
			.pathParam("qualquercoisa", "users")
			.queryParam("page", 2)
		.when()
			.get("/{qualquercoisa}") 
		.then()
			.assertThat()
			.statusCode(200)
		.extract().response();
		
		//desserializando
		JsonPath jp = new JsonPath(res.asString());
				
		System.out.println(jp.getInt("total"));
		System.out.println(jp.getString("data[4].first_name"));
		
		//Hard Assert
		//assertEquals(jp.getString("data[4].first_name"), "George");
		//assertEquals(jp.getInt("total"), 12);
		
		//Soft Assert
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(jp.getString("data[4].first_name"), "George2"); //forcando erro
		sa.assertEquals(jp.getInt("total"), 12);
		sa.assertAll();
			
	}
	
	@Test
	public void desPOJO() {
		Response res = //definindo variavel para usar na resposta
		given()
			.pathParam("qualquercoisa", "users")
			.queryParam("page", 2)
		.when()
			.get("/{qualquercoisa}") 
		.then()
			.assertThat()
			.statusCode(200)
		.extract().response(); //extraindo resultado
		
		POJO_Example des = res.getBody().as(POJO_Example.class);
		
		System.out.println(des.getTotal());
		System.out.println(des.getData().get(1).getLastName());

		assertEquals(des.getTotal(), 12);
		
	}
}
