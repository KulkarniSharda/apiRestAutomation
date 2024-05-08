package aBDDRest;

import org.testng.annotations.Test;


import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class BDDRestAssured2 {
	
	public static void main(String[] args) {
		
		
			RestAssured.baseURI="https://gorest.co.in";
		
		given().log().all().header("Authorization","Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378")
		.when().get("/public/v2/users")
		.then().log().all().assertThat().statusCode(200)
		.header("Content-Type","application/json; charset=utf-8")
		.body("email", hasItem("cybersuccessAPI1713965500225@gmail.com"),
		        "name",hasItems("Vikash","SIK"),
		        "email",not(hasItem("cybersuccejhhghg@gmail.com")),
		        		"email[1]", equalTo("cybersuccessAPI1713965500225@gmail.com"));
	}
	
	

	
		
		
	
	
	
	
}
