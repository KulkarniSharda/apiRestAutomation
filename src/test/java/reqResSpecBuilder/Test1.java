package reqResSpecBuilder;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Test1 {
	
	public RequestSpecification requestData() {
		
		RequestSpecification request	=new RequestSpecBuilder()
				.setBaseUri("https://gorest.co.in").
				addHeader("Authorization","Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378").build();
		
		
		return request;
	}
	
	
	@Test
	public void getcall() {
	
		
		String res1=given().spec(requestData())
		.when().get("/public/v2/users")
		.then().log().all().extract().response().asString();
	}
	
	@Test
	public void getcall1() {
		
		
		String res2=given().spec(requestData())
		.when().get("/public/v2/users/6888879")
		.then().log().all().extract().response().asString();
	}
	
	
	@Test
	public void getcall2() {
		
	RestAssured.baseURI="https://gorest.co.in";
		
		String res3=given().spec(requestData())
		.when().get("/public/v2/users/6888856")
		.then().log().all().extract().response().asString();
	}

}
