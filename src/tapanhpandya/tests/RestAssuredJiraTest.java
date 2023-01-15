package tapanhpandya.tests;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class RestAssuredJiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "http://localhost:8080";
		
		SessionFilter session = new SessionFilter();
		
		String response = given().header("Content-Type", "application/json")
		.body("{ \"username\": \"tapanhpandya\", \"password\": \"Tapan\" }")
		.log().all()
		.filter(session)
		.when().post("/rest/auth/1/session")
		.then().log().all().extract().response().asString();
		
		
		
		given().pathParam("key", "10003").log().all().header("Content-Type", "application/json")
		.body("{\r\n"
				+ "    \"body\": \"I have commented\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "      \"type\": \"role\",\r\n"
				+ "      \"value\": \"Administrators\"\r\n"
				+ "   }\r\n"
				+ "}")
		.filter(session)
		.when().post("/rest/api/2/issue/{key}/comment")
		.then().log().all().assertThat().statusCode(201);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
