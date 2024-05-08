package nonBDDRest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NonBDDRestAssured3 {
	
	public static void main(String[] args) {
		
		
		
		RestAssured rest=new RestAssured();
		
		rest.baseURI="https://gorest.co.in";
		
		RequestSpecification request=rest.given().header("Authorization","Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378");
		
		Response response=rest.when().get("/public/v2/users");
		
		int statuCode=response.getStatusCode();
		String statusLine=response.statusLine();
		
		String obj=response.getBody().prettyPrint();
		
		
		String header=response.header("Content-Type");
		
		System.out.println(statuCode);
		System.out.println("============");
		System.out.println(statusLine);
		System.out.println("============");
		System.out.println();
		System.out.println("============");
		System.out.println(header);
		
		
		
		
	}

}
