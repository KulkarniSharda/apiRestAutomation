package httpsMethods;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapper;
import pojo.CreateNewUserPojo;
import utils.Reusable;

public class TestPostCall {
	
	
	@Test
	public void newUser1() {
		CreateNewUserPojo user=
		new CreateNewUserPojo("ABC", "female", Reusable.randomEmailID(), "active");
		
	RestAssured.baseURI="https://gorest.co.in";
	
	String postResponse=given().log().all().header("Authorization","Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378")
			.header("Content-Type","application/json")
	.body(user)
	.when().post("/public/v2/users")
	.then().log().all().extract().response().asString();
	
	System.out.println("Post body==>"+postResponse);
	
	ObjectMapper mapper=new ObjectMapper();
	
	try {
		CreateNewUserPojo userResponse=mapper.readValue(postResponse, CreateNewUserPojo.class);
		
		System.out.println("user response =="+userResponse);
		
		//fetch the id and name
		Integer id =userResponse.getId();
		System.out.println("User response id "+id);
		String name=userResponse.getName();
		System.out.println("user response name "+name);
		
		Assert.assertEquals(userResponse.getName(), user.getName());
		
		
		
	} catch (JsonMappingException e) {
		e.printStackTrace();
	} catch (JsonProcessingException e) {
		e.printStackTrace();
	}
	
	
	
	}
	
	
	
	
	

}
