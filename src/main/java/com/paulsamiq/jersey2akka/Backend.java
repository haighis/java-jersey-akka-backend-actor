package com.paulsamiq.jersey2akka;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Backend extends UntypedActor {
    
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	
	public static Props mkProps() {
		return Props.create(Backend.class);
	}
	
	@Override
	public void preStart() {
	    log.debug("starting");
	}
	
    public void onReceive(Object message) {
        
        if(message instanceof LogMessage)
        {
        	System.out.println("IN backend");
        	System.out.println("IN backend message is: " + ((LogMessage)message).getTitle() );
        }
        else unhandled(message);
        {
        
        }
    }
}