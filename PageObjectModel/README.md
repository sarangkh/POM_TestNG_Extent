Facebook Sign Up demo
===========================================================================================

## Objective

Signup a new account for Facebook using randomly generated data. You only need to automate the happy path scenario, but you should write your solution such that it would be easy to add negative test cases later.

## Note - I have used excel for data input rather than random string because if I use random data by creating random data generation methods and hits on Facebook it blocks my IP, faced issues with that so using excel parameterization approach which will actually help in adding negative data conditions very easily and test the functionality with data driven approach as well. Added few in current test.

## This solution illustrate below concepts.

## Page Object Model with Page Factory:

In Page Object Pattern operations and flows in the UI are be separated from verification. This concept makes code cleaner and easy to understand. Page Object Model is a design pattern to create Object Repository for web UI elements. Under this model, for each web page in the application, there should be corresponding page class. This Page class will find the WebElements of that web page and also contains Page methods which perform operations on those WebElements.

One more advantage of POM is keeping object repository independent of test cases, so we can use the same object repository for a different purpose with different tools. For example, **we can integrate POM with TestNG/JUnit for functional Testing and at the same time with JBehave/Cucumber for acceptance testing.**
In this solution I have used TestNG for functional testing.

## Extent Report:
Advantages of using Extent Reports are:-
1. Customisable HTML report with stepwise and pie chart representation.
2. Displays the time taken for test case execution within the report.
3. Each test step can be associated with a screenshot.
4. Multiple test case runs within a single suite can be tracked easily.
5. Can be easily integrated with TestNG and JUnit frameworks.

Detail HTML report will generate in **reports** folder after execution. Open the folder in explorer and look for the latest generated report.

## Hybrid Framework

By writing Xls reader and DataUtil classes this framework is flexible enough to write tests in modular as well as data driven approach

SignUp test is been developed using data driven approach for validating various negative inputs and respective error messages on facebook signup screen.

In data folder there is one Data.xlsx file in which test data can be added for respective tests. This same excel can be used for other tests as well like, login test, profile test, personal details test and so on.

Xls reader has reusable methods using which data can be read from excel with column name as a parameter and DataUtil class helps to add data in excel and pass it to test without change in code.

In this demo I have added 6 data conditions as below out of which 5 are negative to validate error messages:-

1. Try to sign up keeping First name blank and validating error messages which I kept intentionally wrong to ensure that test is failing with appropriate log message and screenshot in report. 
2. Try to sign up keeping last name blank and validating error message.
3. Try to sign up by different email in re-enter email field and it should validate error message
4. Try to sign up without selecting gender and validate error message, here again validating it with wrong error message intentionally.
5. Try to sign up with valid inputs, user should sign up successfully and there should not be any error message so in excel error message is blank. - could not validate much after sign up because after signup to facebook sometimes it asks for validate email or enter code which has sent on email.
6. Try to sign up by not entering email again and validate error message.

**We can add any data condition in excel row with expected error message or if the data is valid then keep error message as blank. By this adding any negative data condition is very easy in sign up test and can be run on the basis of Y/N flag.**

**Even adding new pages and tests are also easy as this is POM pattern and reporting ad data utility can be reuse for any page or any validation.**

**Y/N flags at Test cases and test data level can help to execute the tests or data conditions in test on demand.**

This project is a Maven project so all the dependencies are mentioned in pom.xml file, no need to maintain jar files for dependent libraries used in framework development like POI, TestNG, Selenium and extent report.

To use the project follow the below steps:-

- **Clone this repository**
- **Open the solution in Eclipse or intellij**
- **Rebuild**
- **Run the SignUp test**
