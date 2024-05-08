package TestofRestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRest {

	@BeforeTest
	public void testbefore() {
		System.out.println("I am opening API============");
		
	}
	@Test
	public void test1() {
		RestAssured.baseURI = "https://reqres.in/";
		String response = given().header("Content-Type", "Application/json").when().log().all().get("/api/users?page=2").then()
				.log().all().statusCode(200).extract().response().prettyPrint().toString();
		System.out.println("response" + response);
	}

	@AfterTest
	public void testAfter() {
		System.out.println("I am Closing API=================");
		
	}
}
