package com.Telecom.API;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CapstoneProject_TelecomDomain {

	 
		 String tokenvalue;
		 String logintoken;
		 String id;
	
	@Test(priority=1)
	public void addNewUser() 
	{
		 Response  res=given()
		  .header("Content-Type","application/json")
		  .header("Accept","application/json")
		  .body("{ \n"
		  		+ "\"firstName\": \"Diksha\", \n"
		  		+ "\"lastName\": \"Sukhija\", \n"
		  		+ "\"email\": \"diksha"+System.currentTimeMillis()+"@gmail.com\", \n"
		  		+ "\"password\": \"test123\" \n"
		  		+ "}")
		 .when().post("https://thinking-tester-contact-list.herokuapp.com/users");
		  res.then().log().body();
		  tokenvalue=res.jsonPath().getString("token");
		  System.out.println("New User created with status code: "+res.statusCode());
	}
	@Test(priority=2,dependsOnMethods ="addNewUser")
	public void getProfile()
	{
		  Response res=given()
		  .header("Content-Type","application/json")
		  .header("Accept","application/json")
		  .header("Authorization","Bearer "+tokenvalue)
		  .when().get("https://thinking-tester-contact-list.herokuapp.com/users/me");
		  res.then().log().body();
		  System.out.println("User Profile get createed with id: "+res.statusCode());
	}
	@Test(priority=3)
	public void updateUser()
	{
		  Response res=given()
		  .header("Content-Type","application/json")
		  .header("Accept","application/json")
		  .header("Authorization","Bearer "+tokenvalue)
		  .body("{ \n"
		  		+ "\"firstN ame\": \"Diksha\", \n"
		  		+ "\"lastName\": \"Narayani\", \n"
		  		+ "\"email\": \"diksha"+System.currentTimeMillis()+"@gmail.com.com\", \n"
		  		+ "\"password\": \"test123\" \n"
		  		+ "} ")
		  .when().patch("https://thinking-tester-contact-list.herokuapp.com/users/me");
		  res.then().log().body();
		  System.out.println("User updated with status code : "+res.statusCode());

	}
	@Test(priority=4)
	public void loginUser()
	{
		  Response res=given()
		  .header("Content-Type","application/json")
		  .header("Accept","application/json")
		  .body("{ \n"
		  		+ " \n"
		  		+ " \n"
		  		+ "\"email\": \"diksha24@gmail.com\", \n"
		  		+ "\"password\": \"test123\" \n"
		  		+ " \n"
		  		+ "} \n"
		  		+ " ")
		  .when().post("https://thinking-tester-contact-list.herokuapp.com/users/login");
		  res.then().log().body();
		  logintoken=res.jsonPath().getString("token");
		  System.out.println("User login with status code: "+res.statusCode());
	}
	@Test(priority=5)
	public void addContact()
	{
		  Response res=given()
		  .header("Content-Type","application/json")
		  .header("Accept","application/json")
		  .header("Authorization","Bearer "+logintoken)
		  .body("{ \n"
		  		+ "\"firstName\": \"diksha\", \n"
		  		+ "\"lastName\": \"narayani\", \n"
		  		+ "\"birthdate\": \"1950-02-19\", \n"
		  		+ "\"email\": \"dikshaTest@gmail.com\", \n"
		  		+ "\"phone\": \"9833413500\", \n"
		  		+ "\"street1\": \"1 Lokhandwala St.\", \n"
		  		+ "\"street2\": \"Apartment A\", \n"
		  		+ "\"city\": \"Anytown\", \n"
		  		+ "\"stateProvince\": \"KS\", \n"
		  		+ "\"postalCode\": \"400053\", \n"
		  		+ "\"country\": \"USA\" \n"
		  		+ "}")

		  .when().post("https://thinking-tester-contact-list.herokuapp.com/contacts");
		  res.then().log().body();
		  id=res.jsonPath().getString("_id");
		  System.out.println("User contact created with status code: "+res.statusCode());
	}

	@Test(priority=6)
	public void getContactList()
	{
		  Response res=given()
				  .header("Content-Type","application/json")
				  .header("Accept","application/json")
				  .header("Authorization","Bearer "+logintoken)
				  .when().get("https://thinking-tester-contact-list.herokuapp.com/contacts");
		  res.then().log().body();
		  System.out.println("Contact list with code: "+res.statusCode());

	}

	@Test(priority=7)
	public void getContact()
	{
		  Response res=given()
	.header("Content-Type","application/json")
	.header("Accept","application/json")
	.header("Authorization","Bearer "+logintoken)
	.when().get("https://thinking-tester-contact-list.herokuapp.com/contacts");
	 
	res.then().log().body();
	 
	System.out.println("Contact data with code: "+res.statusCode());
	}
	@Test(priority=8)
	public void updateContact()
	{
		  Response res=given()
		  .header("Content-Type","application/json")
		  .header("Accept","application/json")
		  .header("Authorization","Bearer "+logintoken)
		  .body("{ \n"
		  		+ "\"firstName\": \"Diksha\", \n"
		  		+ "\"lastName\": \"Narayani\",\n"
		  		+ " \n"
		  		+ " \n"
		  		+ "\"birthdate\": \"1995-02-20\", \n"
		  		+ "\"email\": \"newdiksha@gmail.com\", \n"
		  		+ "\"phone\": \"9833413500\", \n"
		  		+ "\"street1\": \"13 Khar St.\", \n"
		  		+ "\"street2\": \"Apt. 5\", \n"
		  		+ "\"city\": \"Washington\", \n"
		  		+ "\"stateProvince\": \"QC\", \n"
		  		+ "\"postalCode\": \"3434545\", \n"
		  		+ "\"country\": \"Canada\" \n"
		  		+ "} ")

		  .when().put("https://thinking-tester-contact-list.herokuapp.com/contacts/"+id);
		  res.then().log().body();
		  System.out.println("User updated with code: "+res.statusCode());
	}

	@Test(priority=9)
	public void updateContactpatch()
	{
		  Response res=given()
				  .header("Content-Type","application/json")
				  .header("Accept","application/json")
				  .header("Authorization","Bearer "+logintoken)
				  .body("{ \n"
				  		+ "\"firstName\": \"Jack\", \n"
				  		+ "\"lastName\": \"Sen\"} ")
				  .when().put("https://thinking-tester-contact-list.herokuapp.com/contacts/"+id);
		  res.then().log().body();
		  System.out.println("User updated with code: "+res.statusCode());
	}
	@Test(priority=10)
	public void logoutUser()
	{
		  Response res=given()
		  .header("Content-Type","application/json")
		  .header("Accept","application/json")
		  .header("Authorization","Bearer "+logintoken)
		  .when().post("https://thinking-tester-contact-list.herokuapp.com/users/logout");
		  res.then().log().body();
		  System.out.println("User logout with code: "+res.statusCode());
	}

	 
	}


