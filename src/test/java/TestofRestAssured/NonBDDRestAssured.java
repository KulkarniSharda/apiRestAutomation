package TestofRestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NonBDDRestAssured {

	public static void main(String[] args) {
		
		
		
		RestAssured rest=new RestAssured();
		
		rest.baseURI="https://gorest.co.in";
		
		RequestSpecification request=rest.given().
		header("Authorization","Bearer e41e3161131f43d0c912ecf2ca080f47042fcefe3639875530a71b300b406aee");
		
		Response response=request.when().get("/public/v2/users/6860920");
		
		//printing status code
		int statusCode=response.statusCode();
		System.out.println("Status code is ==>"+statusCode);
		
		//print status line
		String statusLine=response.statusLine();
		System.out.println("Status line is ==>"+statusLine);
		String statusLineValue=statusLine.substring(9);
		System.out.println("Status line after substring ==>"+statusLineValue);
		
		/*
		 * Status code is ==>502 Status line is ==>HTTP/1.1 502 Bad Gateway Status line
		 * after substring ==>502 Bad Gateway
		 */
		
	}

}
