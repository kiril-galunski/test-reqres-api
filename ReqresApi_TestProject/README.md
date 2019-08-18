# ReqresApi_TestProject

###### 

This automation project tests the http://reqres.in API. 
It was created using Eclipse IDE with Java & Maven, using **Cucumber**, **REST-assured**, **TestNG** and **JUnit**. 
All the versions are specified in the **pom.xml** located in the main project directory.

## Project description ([Screenshot](https://i.imgur.com/4wFDLDD.png]))
**ReqresApi_TestProject** consist the following:
- **ReqresApi.feature** file located in "*resourced/features*" which describes all Gherkin Scenarios - 6 implemented and 4 not implemented
- **StepDefinitions_ReqresAPI** class with the Step Definition methods for the implemented scenario steps
- **TestReqres** class located in the "*testReqres*" package which has all the methods for the implemented Step Definitions in the above class
- **TestRunner_ReqresApi** class located in the "*reqres_TestRunner*" package - the standart Cucumber test runner (hat runs the tests)

## Steps to run the tests:
- Download the project from GitHub and load it in the IDE of your choise
- Make sure your IDE has all the tools and libraries needed (**Cucumber**, **REST-assured**, **TestNG** and **JUnit**). 
You shouldn't have unresolved imports in the code or missing dependencies.
Add the *.jar* files to your library, located in the project foled: 
[**junit-4.13-beta-3.jar**](https://github.com/kiril-galunski/test-reqres-api/blob/master/ReqresApi_TestProject/junit-4.13-beta-3.jar)
and all the jar files in [**rest-assured-4.0.0-dist.zip**](https://github.com/kiril-galunski/test-reqres-api/blob/master/ReqresApi_TestProject/rest-assured-4.0.0-dist.zip)
(that's **rest-assured-4.0.0.jar** plus all the jars in the *"rest-assured-4.0.0-deps"* folder). 
If you are missing something check in [THIS](https://i.imgur.com/sdBKkrq.png) list of jars, it might be of help.
- Run the **TestRunner_ReqresApi** with **JUnit** and observe the test results ([Screenshot](https://i.imgur.com/tgMQn7o.png]))

*Additional notes*: The second step could take some tweaking (at least it did to me, probably due to the total lack of unexperience).
The project was created on a MacBook (Eclipse IDE), uploaded to GitHub and then downloaded and tested on Windows 10 PC (Eclipse IDE).
