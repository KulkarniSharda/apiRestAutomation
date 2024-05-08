package nonBDDRest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NonBDDRestAssured {
	
	public static void main(String[] args) {
		
		
		
		RestAssured rest=new RestAssured();
		
		rest.baseURI="https://gorest.co.in";
		
		RequestSpecification request=rest.given().
		header("Authorization","Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378");
		
		Response response=request.when().get("/public/v2/users/6860920");
		
		//printing status code
		int statusCode=response.statusCode();
		System.out.println("Status code is ==>"+statusCode);
		
		//print status line
		String statusLine=response.statusLine();
		System.out.println("Status line is ==>"+statusLine);
		String statusLineValue=statusLine.substring(9);
		System.out.println("Status line after substring ==>"+statusLineValue);
		
		
		
	}

}
