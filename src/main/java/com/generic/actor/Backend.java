package com.generic.actor;

import com.generic.datamodel.LogMessage;
import com.generic.service.LogService;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Backend extends UntypedActor {
    
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	private LogService logService;
	
	public static Props mkProps() {
		return Props.create(Backend.class);
	}
	
	@Override
	public void preStart() throws Exception {
		// Create db connection
		logService = new LogService();
		log.debug("starting");
	}
	
    public void onReceive(Object message) throws Exception {
        
        if(message instanceof LogMessage)
        {
    	    logService.SaveMessage((LogMessage)message);
        }
        else 
        {
        	unhandled(message);
        }
    }
}