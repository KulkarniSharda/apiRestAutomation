package TestofRestAssured;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class E2E4 {
	
	
	
	
	
	@Test
	public void postCall() {
		
		File file=new File("./src/test/resources/files/payload.json");
		
		//post
		RestAssured.baseURI="https://gorest.co.in";
		
		Response postResponse=given().log().all().header("Authorization","Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378")
				.header("Content-Type","application/json")
		.body(file)
		.when().post("/public/v2/users")
		.then().log().all().extract().response();
		
		int statusCode=postResponse.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		
		//fetch the id 
		JsonPath js=new JsonPath(postResponse.asString());
		
		int id=js.get("id");
		System.out.println("id =="+id);
		
		System.out.println("========================================================");
		
		
		
		
	}

}
