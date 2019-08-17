package testReqres;


import org.json.simple.JSONObject;
// import org.junit.BeforeClass; - not used, explained below
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestReqres {

	Response response=null; 
	
/* ---- I lost hours trying to make this cleaner by using a setup method and @BeforeClass,
but kept getting Connection Refused errors so I gave up. :(( 

	@BeforeClass
	public void initialSetup() 
	{
		
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://reqres.in:80/";
		// Get the RequestSpecification of the request that we want to sent to the server.
	}
	
	RequestSpecification httpRequest=RestAssured.given(); */

// Scenario 1 When Step Method:
	public void TestReqres_S1_Get_Call()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://reqres.in/";
		// Get the RequestSpecification of the request that we want to sent to the server.
		RequestSpecification httpRequest=RestAssured.given();
		
		// Make sure the response is cleared before storing it
		response = null; 
		response = httpRequest.get("api/unknown");
	}

// Scenario 1 Then Step Method:
	@Test
	public void TestReqres_S1_Get_Check()
	{		
		// Get the status code
		int statusCode = response.getStatusCode();
		
		// Assert that correct status code is returned.
	    Assert.assertEquals(statusCode, 200, "FAILED: Status Code incorrect");
	}

// Scenario 2 When Step Method:
	public void TestReqres_S2_Get_Call()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://reqres.in/";
		// Get the RequestSpecification of the request that we want to sent to the server.
		RequestSpecification httpRequest=RestAssured.given();
		
		// Make sure the response is cleared before storing it
		response = null; 
		response = httpRequest.get("api/users/2");
	}

// Scenario 2 Then Step Method:
	@Test
	public void TestReqres_S2_Get_Check()
	{
		String responseAsString = response.asString();
		int idValue = JsonPath.with(responseAsString).get("data.id");
		
		// Validate the response
		Assert.assertEquals(idValue, 2, "FAILED: incorrect user id");
	}

// Scenario 4 When Step Method:
	public void TestReqres_S4_Post_Call()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://reqres.in/";
		// Get the RequestSpecification of the request that we want to sent to the server.
		RequestSpecification httpRequest=RestAssured.given();
		
		// Add Key - Value pairs
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", "kgalunski@email.com"); 
				
		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");
		 
		// Add the Json to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		// Make sure the response is cleared before storing it
		response = null; 
		response = httpRequest.post("api/login");
		}

// Scenario 4 Then Step Method:
	@Test
	public void TestReqres_S4_Post_CheckStatusCode()
	{
		// Get the status code
		int statusCode = response.getStatusCode();
		
		// Assert that correct status code is returned.
	    Assert.assertEquals(statusCode, 400, "FAILED: Status Code incorrect");
	}

//Scenario 4 And Step Method:
	@Test
	public void TestReqres_S4_Post_CheckErrorMessage()
	{
		String responseAsString = response.asString();
		String errorMsg = JsonPath.with(responseAsString).get("error");
		
		// Validate the response
		Assert.assertEquals(errorMsg, "Missing password", "FAILED: Error message incorrect");
	}

	// Scenario 6 When Step Method:
		public void TestReqres_S6_Put_Call()
		{   
			// Specify the base URL to the RESTful web service
			RestAssured.baseURI = "https://reqres.in/";
			// Get the RequestSpecification of the request that we want to sent to the server.
			RequestSpecification httpRequest=RestAssured.given();
			
			// Add Key - Value pairs
			JSONObject requestParams = new JSONObject();
			requestParams.put("name", "Kiril Galunski"); 
			requestParams.put("job", "Automation QA"); 

			// Add a header stating the Request body is a JSON
			httpRequest.header("Content-Type", "application/json");
			 
			// Add the Json to the body of the request
			httpRequest.body(requestParams.toJSONString());
			
			// Make sure the response is cleared before storing it
			response = null; 
			response = httpRequest.put("api/users/2");
			}

	//Scenario 6 And Step Method:
		@Test
		public void TestReqres_S6_Put_CheckData()
		{
			String responseAsString = response.asString();
			String name = JsonPath.with(responseAsString).get("name");
			String job = JsonPath.with(responseAsString).get("job");
			// Validate the response
			Assert.assertEquals(name, "Kiril Galunski", "FAILED: incorrect name");
			Assert.assertEquals(job, "Automation QA", "FAILED: incorrect job");
		}
	
		// Scenario 7 When Step Method:
		public void TestReqres_S7_Patch_Call()
		{   
			// Specify the base URL to the RESTful web service
			RestAssured.baseURI = "https://reqres.in/";
			// Get the RequestSpecification of the request that we want to sent to the server.
			RequestSpecification httpRequest=RestAssured.given();
			
			// Add Key - Value pairs
			JSONObject requestParams = new JSONObject();
			requestParams.put("name", "K.Galunski"); 

			// Add a header stating the Request body is a JSON
			httpRequest.header("Content-Type", "application/json");
			 
			// Add the Json to the body of the request
			httpRequest.body(requestParams.toJSONString());
			
			// Make sure the response is cleared before storing it
			response = null; 
			response = httpRequest.patch("api/users/2");
			}

	//Scenario 7 Then Step Method:
		@Test
		public void TestReqres_S7_Patch_CheckData()
		{
			String responseAsString = response.asString();
			// The next line will return null if "updatedAt" is not found in the response data 
			String updatedAt = JsonPath.with(responseAsString).get("updatedAt");
			// Validate the response
			Assert.assertNotNull(updatedAt, "FAILED: updatedAt is not found");
		}
		
// Scenario 9 When Step Method:
		public void TestReqres_S9_Delete_Call()
		{   
			// Specify the base URL to the RESTful web service
			RestAssured.baseURI = "https://reqres.in/";
			// Get the RequestSpecification of the request that we want to sent to the server.
			RequestSpecification httpRequest=RestAssured.given();
			
			// Make sure the response is cleared before storing it
			response = null; 
			response = httpRequest.delete("api/users/2");
		}

// Scenario 9 Then Step Method:
		@Test
		public void TestReqres_S9_Delete_CheckStatusCode()
		{		
			// Get the status code
			int statusCode = response.getStatusCode();
			
			// Assert that correct status code is returned.
		    Assert.assertEquals(statusCode, 204, "FAILED: Status Code incorrect");
		}		
}