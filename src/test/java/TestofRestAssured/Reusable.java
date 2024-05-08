package TestofRestAssured;

public class Reusable {
public static String randomEmailID() {
	return "mymailid"+System.currentTimeMillis()+"@gmail.com";
	
		
	}


public static String patchJsonBody() {
	String patchbody = "\"status\": \"inactive\"";
	return patchbody;
	
		
	}
public static String postJsonBody() {
	String postbody = "{\r\n"
			+ "    \"name\": \"SK11\",\r\n"
			+ "    \"gender\": \"Female\",\r\n"
			+ "    \"email\": \""+randomEmailID()+"\",\r\n"
			+ "    \"status\": \"active\"\r\n"
			+ "}";
	return postbody;
	
		
}
}
/*
 * { "email": "george.edwards@reqres.in", "first_name": "George", "last_name":
 * "Edwards", "avatar": "https://reqres.in/img/faces/11-image.jpg" }
 */