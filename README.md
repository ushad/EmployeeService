# NarvarAssignment

# Employee Service
This service consists of REST API to perform employee specific operations as per the assignment and covers code only for server side. Doesnot have code for UI. The code doesn't include test cases of any sort as the assignment doesn't mention for Junits. The restful API's have been tested on swagger UI locally.

The technologies used in this application:

* Java 1.8 - Latest oracle java 
* Tomcat - java embedded web server
* Spring Boot 1.3.4 - Java application framework
* Swagger2 - for UI documents
* JUnit - Unit test framework for Java
* Maven -  Apache build manager for Java projects
* 
Postgres configuration is as follows , Change the settings as required in application properties to run in local

spring.datasource.url=jdbc:postgresql://localhost:5432/employeedata
spring.datasource.username=postgres
spring.datasource.password=postgres
* SERVER_PORT=8181

Swagger URL for testing API's.
http://localhost:8181/swagger-ui.html
