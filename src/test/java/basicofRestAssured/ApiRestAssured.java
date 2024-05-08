package basicofRestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiRestAssured {

	public static void main(String[] args) {

		// bearerToken
		// e41e3161131f43d0c912ecf2ca080f47042fcefe3639875530a71b300b406aee

		RestAssured rest = new RestAssured();
		rest.baseURI = "https://gorest.co.in";

		RequestSpecification request = rest.given().header("Authorization",
				"Bearer e41e3161131f43d0c912ecf2ca080f47042fcefe3639875530a71b300b406aee");

		// Response response = request.when().get("/public/v2/users");
		Response response = request.when().post("/public/v2/users");

		int statuscode = response.statusCode();
		System.out.println(statuscode);

		String statusline = response.statusLine();
		System.out.println(statusline);

		if (statuscode == 200) {
			System.out.println("Successful");

		} else {
			System.out.println("Unsuccessful Status Code");

		}

		String statusline1 = statusline.substring(8);
		System.out.println("Status line  ==" + statusline1);

	}

}
