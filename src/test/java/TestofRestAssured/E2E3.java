package TestofRestAssured;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class E2E3 {
	
	
	@DataProvider(name="data")
	public Object[][] testData() {
		
		return new Object[][] {{"vikash","male","active"},{"Nikki","male","inactive"}};
	}
	
	
	
	
	
	@Test(dataProvider = "data")
	public void postCall(Object name,Object gender,Object status) {
		
		
		
		//post
		RestAssured.baseURI="https://gorest.co.in";
		
		Response postResponse=given().log().all().header("Authorization","Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378")
				.header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"gender\": \""+gender+"\",\r\n"
				+ "    \"email\": \""+Reusable.randomEmailID()+"\",\r\n"
				+ "    \"status\": \""+status+"\"\r\n"
				+ "}")
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
