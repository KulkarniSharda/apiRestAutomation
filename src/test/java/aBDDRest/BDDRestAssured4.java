package aBDDRest;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.util.Iterator;
import java.util.List;

public class BDDRestAssured4 {
	
	public static void main(String[] args) {
		
		
			RestAssured.baseURI="https://gorest.co.in";
		
		String res=given().log().all().header("Authorization","Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378")
		.when().get("/public/v2/users")
		.then().log().all().extract().response().asString();
		
		//System.out.println("response =="+res.asString());
		
		JsonPath js=new JsonPath(res);
		
				
		List<Integer> listOfIds=js.get("id");
		
		for(int i=0;i <listOfIds.size();i++) {
			int id=js.get("id["+i+"]");
			System.out.println(id);
			
			if(id==6871056) {
				
			String email=	js.get("email["+i+"]");
			System.out.println(email);
			
			String gender=	js.get("gender["+i+"]");
			System.out.println(gender);
			
			String status=	js.get("status["+i+"]");
			System.out.println(status);
			
			break;
			}
		}
		
		
		
		
	}
	
	

	
		
		
	
	
	
	
}
