package aBDDRest;

import org.testng.annotations.Test;


import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class BDDRestAssured {
	
	@Test
	public void test() {
			RestAssured.baseURI="https://gorest.co.in";
		
		given().log().all().header("Authorization","Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378")
		.when().get("/public/v2/users")
		.then().log().all().assertThat().statusCode(200);
	}
	
	

	
		
		
	
	
	
	
}
