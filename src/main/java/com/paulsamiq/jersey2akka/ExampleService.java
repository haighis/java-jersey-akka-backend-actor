package com.paulsamiq.jersey2akka;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ManagedAsync;

import com.generic.datamodel.LogMessage;

import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.OnComplete;
import akka.event.LoggingAdapter;
import akka.pattern.Patterns;
import akka.util.Timeout;

@Path( "/api/log")
public class ExampleService {
	
	@Context ActorSystem actorSystem;
	LoggingAdapter log;
	
	@GET
//	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test()
	{	
		System.out.println("in get");
		return "test";
	}
	
	@POST
//	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(LogMessage message)
	{
		ActorSelection selection = actorSystem.actorSelection("akka://AuditSystem/user/frontend");
	   System.out.println("in save");
		selection.tell(new LogMessage(message.getTitle()), ActorRef.noSender());
		
		//LogMessage result = message;
		String result = "done " + message;
		return Response.status(201).entity(result).build();
	}
	
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ManagedAsync
	public void getExamples (
			@PathParam("value") Integer value, 
			@Suspended final AsyncResponse res) {
		
		// For Akka 2.2, should use actorSelection,
		// but how to do this outside of an actor?
		ActorRef doublingActor = actorSystem.actorFor("/user/doublingRouter");
		
		Timeout timeout = new Timeout(Duration.create(2, "seconds"));
		
		Future<Object> future = Patterns.ask(doublingActor, value, timeout);
		
		future.onComplete(new OnComplete<Object>() {
			
			public void onComplete(Throwable failure, Object result) {
				
				if (failure != null) {
					
					if (failure.getMessage() != null) {
						HashMap<String,String> response = new HashMap<String,String>();
						response.put("error", failure.getMessage());
						res.resume(Response.serverError().entity(response).build());
					} else {
						res.resume(Response.serverError());
					}
					
				} else {		
					
					HashMap<String,Object> response = new HashMap<String,Object>();
					response.put("results",(Integer)result);
					res.resume(Response.ok().entity(response).build());
					
				}

			}
		}, actorSystem.dispatcher());
		
	}*/

}
