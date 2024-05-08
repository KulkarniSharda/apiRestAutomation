package reqResSpecBuilder;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Test2 {
	
	public RequestSpecification requestData() {
		
		RequestSpecification request	=new RequestSpecBuilder()
				.setBaseUri("https://gorest.co.in").
				addHeader("Authorization","Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378").build();
		
		
		return request;
	}
	
	
public ResponseSpecification responseData() {
		
		ResponseSpecification response 
		=new ResponseSpecBuilder().expectStatusCode(200)
		.expectHeader("Content-Length", "96").build();
		return response;
	}
	
	
	@Test
	public void getcall() {
	
		
		given().spec(requestData()).log().all()
		.when().get("/public/v2/users")
		.then().spec(responseData());
	}
	
	@Test
	public void getcall1() {
		
		
		given().spec(requestData()).when().get("/public/v2/users/6888879")	.then().spec(responseData());
	}
	
	
	@Test
	public void getcall2() {
		
	RestAssured.baseURI="https://gorest.co.in";
		
		given().spec(requestData())
		.when().get("/public/v2/users/6888856")
		.then().log().all().spec(responseData());
	}

}
