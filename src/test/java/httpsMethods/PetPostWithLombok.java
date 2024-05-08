package httpsMethods;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Tags;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.CreatePetStorePojoWithLombok;
import pojo.CreatePetStorePojoWithLombok.Category;

public class PetPostWithLombok {

	@Test
	public void createPetStore() {

		Category cat = new CreatePetStorePojoWithLombok.Category(1, "Store");

		Tags tag1 = new CreatePetStorePojoWithLombok.Tags(10, "pet1");
		Tags tag2 = new CreatePetStorePojoWithLombok.Tags(20, "pet2");

		List<Tags> tag = Arrays.asList(tag1, tag2);
		List<String> photoUrl = Arrays.asList("https://abc.com", "http//xyz.com");

		CreatePetStorePojoWithLombok petRequest = new CreatePetStorePojoWithLombok(12345, cat, "TOM", tag, "available",photoUrl);

		RestAssured.baseURI = "https://petstore.swagger.io";

		String petResponse = given().log().all().header("Content-Type", "application/json").body(petRequest).when()
				.post("/v2/pet").then().extract().response().asString();

		System.out.println(petResponse);

	}

}
