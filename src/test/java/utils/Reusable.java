package utils;

public class Reusable {
	
public static String randomEmailID() {
		
		return "cyber"+System.currentTimeMillis()+"@gmail.com";
	}
	
	
	public static String jsonData() {
		
		
		String body="{\r\n"
				+ "    \"name\": \"Vikash\",\r\n"
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"email\": \""+randomEmailID()+"\",\r\n"
				+ "    \"status\": \"active\"\r\n"
				+ "}";
		
		return body;
	}
	
	public static String patchJsonBody() {
		
		String payload="{\r\n"
				+ "    \r\n"
				+ "    \"status\": \"inactive\"\r\n"
				+ "}";
		
		return payload;
	}

}
