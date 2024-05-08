package aBDDRest;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.util.List;

public class BDDRestAssured3 {
	
	public static void main(String[] args) {
		
		
			RestAssured.baseURI="https://gorest.co.in";
		
		String res=given().log().all().header("Authorization","Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378")
		.when().get("/public/v2/users")
		.then().log().all().extract().response().asString();
		
		//System.out.println("response =="+res.asString());
		
		JsonPath js=new JsonPath(res);
		
		String emailID=js.getString("email[0]");
		System.out.println("emaild ID is "+ emailID);
		
		String emailID4=js.getString("email[3]");
		System.out.println("emaild ID is ==>"+ emailID4);
		
		Assert.assertEquals(emailID4, "Vikas23h.a1223c@gmail.com");
		
		
		int id=js.get("id[9]");
		System.out.println("ID is ==>"+ id);
		
		List<Integer> listOfIds=js.get("id");
		System.out.println(listOfIds.size());
		
		
		
		
	}
	
	

	
		
		
	
	
	
	
}
