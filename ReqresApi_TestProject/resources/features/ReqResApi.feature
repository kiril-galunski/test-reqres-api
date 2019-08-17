Feature: Reqres API requests
This feature verifies the basic functionality of Reqres API - Create, Read, Update, Delete

# Scenario 1
Scenario: Check that a list resource read request is successful
When I send a GET request to the API "api/unknown" endpoint
Then the response Status Line has a Status Code value of 200

# Scenario 2
Scenario: Check that a user read request returns data for the correct user
When I send a GET "api/users/2" request to the API 
Then the response body contains id node with the correct value

# Scenario 3 - not implemented
Scenario: Check that a create user request is successful
When I send a POST request to the API "api/users" endpoint, name" : "Kiril job" : "QA" 
Then the response Status Line has a Status Code value of 201
And the response body contains "name" and "job" nodes with the correct data

# Scenario 4
Scenario: Check that a password is required for a successful Login 
When I send a POST request to the API "api/login" endpoint, "email" : "kgalunski@email.com" 
Then the response Status Line has a Status Code value of 400
And the response body contains "error" node with a value: "Missing password"

# Scenario 5 - not implemented
Scenario: Check that a user full update request is successful
When I send a PUT request to the API "api/users/2" endpoint, "name" : "Kiril Galunski", "job" : "QA" 
Then the response Status Line has a Status Code value of 200

# Scenario 6
Scenario: Check that a user full update request has changed the data correctly
When I send a PUT request to the API "api/users/2" endpoint, "name" : "Kiril Galunski", "job" : "Automation QA" 
Then the response Status Line has a Status Code value of 200
And the response body contains "name" and "job" nodes with the correct data

# Scenario 7
Scenario: Check that a user partial update returns a "updatedAt" node
When I send a PATCH request to the API "api/users/2" endpoint, "name" : "K.Galunski" 
Then the response body contains a "updateAt" node that is not null

# Scenario 8 - not implemented
Scenario: Check that a user partial update request has not deleted any data
When I send a PATCH request to the API "api/users/2" endpoint, "job" : "QA"
Then the response body contains a "name" node with the correct data

# Scenario 9 
Scenario: Check that a delete user request is successful
When I send a DELETE request to the API "api/users/2" endpoint
Then the response Status Line has a Status Code value of 204

# Scenario 10 - not implemented
Scenario: Check that a delete user request has deleted the user
When I send a DELETE request to the API "api/users/2" endpoint
When I send a GET request for the same user
Then the response Status Line has a Status Code value of 404