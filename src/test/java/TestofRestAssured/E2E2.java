package TestofRestAssured;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class E2E2 {

	@Test
	public void e2E() {

		// create a record using POST method
		// Fetch the record using unique id
		// we need to update the record using unique id
		// we can also delete the record using unique id

		// post
		RestAssured.baseURI = "https://gorest.co.in";

		Response postResponse = given().log().all()
				.header("Authorization", "Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378")
				.header("Content-Type", "application/json").body(Reusable.postJsonBody()).when().post("/public/v2/users")
				.then().log().all().extract().response();

		int statusCode = postResponse.getStatusCode();
		Assert.assertEquals(statusCode, 201);

		// fetch the id
		JsonPath js = new JsonPath(postResponse.asString());

		int id = js.get("id");
		System.out.println("id ==" + id);

		System.out.println("========================================================");

		// fetch the id details

		String getResponse = given().log().all()
				.header("Authorization", "Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378")
				.when().get("/public/v2/users/" + id).then().assertThat().statusCode(200).extract().response()
				.asString();

		// JsonPath json=new JsonPath(getResponse);

		System.out.println(getResponse);

		System.out.println("========================================================");

		// update the status as inactive

		String patchResponse = given().log().all()
				.header("Authorization", "Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378")
				.header("Content-Type", "application/json").body(Reusable.patchJsonBody()).when()
				.patch("/public/v2/users/" + id).then().log().all().assertThat().statusCode(200).extract().response()
				.asString();

		System.out.println(patchResponse);

	}

}
