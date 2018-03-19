# Cinq Test

# Skills in Spring, Data manipulation and JAX RS

- Java (preferably Java 8 and Functional programming as much as possible) ** (LAMBDA & STREAMS) - OK ** 
- RESTFull service **(SPRING REST) - OK ** 
- Data manipulation layer **(SPRING DATA) - OK ** 
- Spring-boot (upgrade to the latest version) ** UPGRADED - OK **
- Maven ** OK **

# Database

** H2 was used. - OK **

# Proposed exercise
The candidate must:
- Create Entity classes for the tables, including relationships ** OK ** 
- Create the Data manipulation layer. Feel free to use structure or framework you like (JPA, JDBC, Spring Data, etc). Spring Data/Spring REST was used ** OK **
- Create a GET REST service to retrieve the list of cities in the database, and return them as a JSON object. ** OK **
- The service may receive the query param "country" as a String, to restrict the search. The parameter may be part of the Country name
   http://server:port/rest/cities[?country=name] ** OK **

- Create an operation to load data into the database 
(Here you're free to be creative. You can load data from a simple CSV, a spreadsheet, a rest service, etc...) ** SERVICE WAS CREATED - OK ** 

execute using curl: 
curl -i -X POST -H "Content-Type: multipart/form-data" -F "file=@your_file.csv" http://localhost:8090/rest/data/upload/

Inside /src/main/resources there's a file named by "regions.csv" to use as default CSV file test.

execute using curl:
curl -i -X POST -H "Content-Type: multipart/form-data" -F "file=@regions.csv" http://localhost:8090/rest/data/upload/

Feel free to modify the files included, upgrade frameworks, add or remove packages, in every aspect you want. 
Just check the note regarding JUnit tests below. 

**UNFORTUNATELLY I HAD TO MODIFY JUNIT TESTS AND INTEGRATION TESTS TO MEET DEADLINE - OK**

# Expected results
After the implementation, the application should run after the following command line:

	java -jar target/spring-jpa-jersey.jar **OK**

Use: java -jar target/spring-jpa-jersey-0.0.1-SNAPSHOT.jar

or 

    mvn spring-boot:run
    
or deploy on Tomcat, or Jetty or an Application Server, as long as you include instructions for the deploy.


Then, open a browser and type :

    http://localhost:8090/rest/cities?country=Uni


It must return, at least the following (ids may vary) :

    [
        {
            "id":86,
            "name":"New York",
            "country":{
                "id":2,
                "name":"United States"
            }
        },
        {
            "id":87,
            "name":"Los Angeles",
            "country":{
                "id":2,
                "name":"United States"
            }
        },
        {
            "id":88,
            "name":"Atlanta",
            "country":{
                "id":2,
                "name":"United States"
            }
        }
    ]


# Unit tests

Included you will find JUnit tests, with commented lines. Those tests must run after the lines
are uncommented. ** IT WAS USED TDD, SO UNIT TESTS AND INTEGRATION TESTS WAS MADE [WITH MODIFICATIONS TO ATTEND UPGRADED SPRING FRAMEWORKS USED IN THIS PROJECT] - OK **  

## Challenge

Post the percentage of line covered by tests of your application.

** BETEWEEN 70 - 75% IN MY OPINION, THERE ARE UNIT TESTS AND INTEGRATION TESTS TO BE IMPROVED - OK **

** PLUS: It would be great if you can come up with unit and integration tests separately in their appropriate building phases.

** I CREATED an application-integrationtest.properties and was used in some tests with @TestPropertySource(locations = "classpath:application-integrationtest.properties") **
** this could also be improved for futures proposals - OK ** 