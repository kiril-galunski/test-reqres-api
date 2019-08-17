package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testReqres.TestReqres;

public class StepDefinitions_ReqresAPI {
	
	TestReqres teststeps = new TestReqres(); 
// Scenario 1:
	@When("^I send a GET request to the API \"api/unknown\" endpoint$")
	public void s1_i_send_a_get_request_to_unknown() throws Exception { 
			teststeps.TestReqres_S1_Get_Call(); 
	}
	
	//this step is also used in Scenario 6
	@Then("^the response Status Line has a Status Code value of 200$")	
	public void s1_s6_statuscode_check_200() throws Exception { 
			teststeps.TestReqres_S1_Get_Check();
	}

// Scenario 2:
		@When("^I send a GET \"api/users/2\" request to the API$")
		public void s2_i_send_a_get_request_to_users() throws Exception { 
			teststeps.TestReqres_S2_Get_Call(); 
		}
		
		@Then("^the response body contains id node with the correct value$")	
		public void s2_id_value_idvalue_check() throws Exception { 
			teststeps.TestReqres_S2_Get_Check();
		}
		

// Scenario 4:
		@When("^I send a POST request to the API \"api/login\" endpoint, \"email\" : \"kgalunski@email.com\"$")
		public void s4_i_send_a_POST_request_to_the_API_endpoint() throws Exception {
			teststeps.TestReqres_S4_Post_Call();	
		}

		@Then("^the response Status Line has a Status Code value of 400$")	
		public void s4_statuscode_check_400() throws Exception { 
				teststeps.TestReqres_S4_Post_CheckStatusCode();
		}
		
		@Then("^the response body contains \"error\" node with a value: \"Missing password\"$")	
		public void s4_check_error_message() throws Exception { 
			teststeps.TestReqres_S4_Post_CheckErrorMessage();
		}
		

// Scenario 6:
		@When("^I send a PUT request to the API \"api/users/2\" endpoint, \"name\" : \"Kiril Galunski\", \"job\" : \"Automation QA\"$")
		public void s6_i_send_a_PUT_request_to_the_API_endpoint() throws Exception {
			teststeps.TestReqres_S6_Put_Call();	
		}
 
		@Then("^the response body contains \"name\" and \"job\" nodes with the correct data$")	
		public void s6_check_data() throws Exception { 
			teststeps.TestReqres_S6_Put_CheckData();
		}
		
// Scenario 7:
		@When("^I send a PATCH request to the API \"api/users/2\" endpoint, \"name\" : \"K.Galunski\"$")
		public void s7_i_send_a_PATCH_request_to_the_API_endpoint() throws Exception {
			teststeps.TestReqres_S7_Patch_Call();	
		}
 
		@Then("^the response body contains a \"updateAt\" node that is not null$")	
		public void s7_check_data() throws Exception { 
			teststeps.TestReqres_S7_Patch_CheckData();
		}		
		
// Scenario 9:
		@When("^I send a DELETE request to the API \"api/users/2\" endpoint$")
		public void s9_i_send_a_DELETE_request_to_the_API_endpoint() throws Exception {
			teststeps.TestReqres_S9_Delete_Call();	
		}
 
		@Then("^the response Status Line has a Status Code value of 204$")	
		public void s9_check_data() throws Exception { 
			teststeps.TestReqres_S9_Delete_CheckStatusCode();
		}
		
		
}
		
