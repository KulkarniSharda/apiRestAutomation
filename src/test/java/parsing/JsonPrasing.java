package parsing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.List;

public class JsonPrasing {
	
	
	@Test
	public void test1() {
		
		RestAssured.baseURI="http://localhost:3000";
		
		String response=given()
				.when().get("/book")
				.then().extract().response().asString();
		//System.out.println(response);
		
		//Print No of courses returned by API
		JsonPath js=new JsonPath(response);
		
		List<String> noOfCourses=js.get("courses");
		int count=noOfCourses.size();
		System.out.println("No of Courses ==>"+count);
		
		//Print No of courses returned by API--another way
		
		int noOfCourses1=js.get("courses.size()");
		System.out.println("No of Courses1==> "+noOfCourses1);
		
		//Print Purchase Amount
	int purchaseAmt=	js.getInt("dashboard.purchaseAmount");
	System.out.println("PurchaseAmt==>"+purchaseAmt);
	
	//Print Title of the first course
	String title=js.getString("courses[0].title");
	System.out.println("Title of course 1==>"+title);
	
	
	
	//Print All course titles and their respective Prices

	int allCourses=js.get("courses.size()");
	
	for(int i=0;i<allCourses;i++) {
		
		String title1=js.getString("courses["+i+"].title");
		int price=js.get("courses["+i+"].price");
		
		System.out.println("Title of Courses ==>"+title1 +"<===>"+"Price of courses==>"+price);
	}
	
	//Print no of copies sold by API Course
	int allCourses1=js.get("courses.size()");
	
	for(int i=0;i<allCourses1;i++) {
		
		String title1=js.getString("courses["+i+"].title");
		int price=js.get("courses["+i+"].price");
		
		System.out.println("Title of Courses ==>"+title1 +"<===>"+"Price of courses==>"+price);
		
		if(title1.equalsIgnoreCase("api")) {
			
			int copies=js.get("courses["+i+"].copies");
			System.out.println("copies sold by API Course==>"+copies);
		}
	}
	
	
	//Verify if Sum of all Course prices matches with Purchase Amount
	
int allCourses2=js.get("courses.size()");
	
int sum=0;
	for(int i=0;i<allCourses2;i++) {
		
		int price=js.get("courses["+i+"].price");
		
		sum=sum+price;
	
	}
	System.out.println("total no of price=="+sum);
	
	
	int purchaseAmount=	js.getInt("dashboard.purchaseAmount");
	System.out.println("PurchaseAmt==>"+purchaseAmount);
	
	Assert.assertEquals(purchaseAmount, sum);
	
	if (purchaseAmount==sum) {
		System.out.println(" passed");
	}else {
		System.out.println("Failed");
	}
	
	
	
	
	
	
	
		
		
		
		
		
	}

}
