java-jersey-akka-backend-actor
=================

An example of:

- sample written entirely in Java. 
- asynchronous REST API written in Java using Jersey 2 
- Akka 2.3 with backend actor using actor selection

Key concepts
------------
* Instantiating an Akka ActorSystem at server startup and injecting it into each request
* Fulfilling an asynchronous Jersey REST service invocation using Akka actors

How to run the example
----------------------
1. Clone this repository
2. Run `mvn tomcat7:run`
3. Visit `http://localhost:9090/examples/2` via curl or your favorite browser

Prerequisites
-------------
* JDK 7.x
* Maven 3.x
