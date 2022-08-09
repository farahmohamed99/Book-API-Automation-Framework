# Book-API-Automation-Framework

Book Rest APIs tests using : https://fakerestapi.azurewebsites.net/index.html 

Prerequisites:
<br>

    •	Install Lombok plugin
    
    •	Install TestNG plugin


A RestAssured API automation framework using:
<br>

    •	Java 11
    
    •	RestAssured
   
    •	Maven
    
    •	TestNG
    
    •	Reporting with Extent report
    
    •	Lombok library: An annotation-based Java library that allows you to reduce boilerplate code 

# Project Structure:
  The framework is divided into 2 parts:
  - Main: Contains APIs, models, data generator, assertions, helper functions, and properties file reader.
  - Test: Contains all tests and data providers.
# APIs:
  - GetBooks: a get request that retuns an array of book objects.
  - GetBook: a get request that takes an id as a path parameter and retuns a book object.
  - AddBook: a post request that takes a book object and returns a book object.
  - UpdateBook: a put request that takes an id as a path parameter and a book object and returns a book object.
  - DeleteBook: a delete request that takes an id and returns nothing.
# After running the tests:
  - A HTML report will be generated in output folder with the tests result.
