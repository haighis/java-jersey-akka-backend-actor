package com.paulsamiq.jersey2akka;

import akka.actor.ActorSelection;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Frontend extends UntypedActor {
    
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	
	public static Props mkProps() {
		return Props.create(Frontend.class);
	}
	
	@Override
	public void preStart() {
	    log.debug("starting");
	}
    
    public void onReceive(Object message) {
        if (message instanceof LogMessage)
        {   
        	System.out.println("IN frontend");
        	
            ActorSelection selection = getContext().actorSelection("akka://ExampleSystem/user/backend");
            selection.tell(new LogMessage(((LogMessage) message).getTitle()), getSelf());
        }	
        else
        {
        	unhandled(message);
        }
    }
}
