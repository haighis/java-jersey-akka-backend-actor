java-jersey-akka-backend-actor
=================

An example of:

- sample written entirely in Java. 
- asynchronous REST API written in Java using Jersey 2 
- Akka 2.3 with MySQL backend actor using actor selection from frontend actor

Key concepts
------------
* Instantiating an Akka ActorSystem at server startup and injecting it into each request
* Fulfilling an asynchronous Jersey REST service invocation using Akka actors

How to run the example
----------------------
Clone this repository
Run 'mvn clean'
Run `mvn tomcat7:run`
Visit `http://localhost:8080/java-jersey-akka-backend-actor/api/log` issue a GET request via curl or your favorite browser
Visit `http://localhost:8080/java-jersey-akka-backend-actor/api/log` and issue a POST, body message with a json payload of {"title":"this is a test"} 
If using Chrome extension Postman you will also need to specify the Content-Type application/json as Postman requires this to function. 
If the above url's don't work then try dropping java-jersey-akka-backend-actor from the url as: http://localhost:8080/api/log

Prerequisites
-------------
* JDK 7.x
* Maven 3.x
