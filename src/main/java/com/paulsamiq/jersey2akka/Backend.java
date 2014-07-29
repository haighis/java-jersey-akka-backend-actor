package com.paulsamiq.jersey2akka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

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
	public void preStart() throws Exception {
		
		// Create db connection
		log.debug("starting");
	}
	
    public void onReceive(Object message) throws Exception {
        
        if(message instanceof LogMessage)
        {
        	Connection conn = getConnectionMySql();
    	    Statement stmt = conn.createStatement();
    	    String title = ((LogMessage)message).getTitle();
    	    
    	    stmt.executeUpdate("INSERT INTO LogMessage (message) VALUES('" + title +"');");

    	    stmt.close();
    	    conn.close();
        	System.out.println("IN backend");
        	System.out.println("IN backend message is: " +  title );
        }
        else unhandled(message);
        {
        
        }
    }
    
    private Connection getConnection() throws Exception {
        Class.forName("org.hsqldb.jdbcDriver");
        String url = "jdbc:hsqldb:mem:data/tutorial";

        return DriverManager.getConnection(url, "sa", "");
      }
    
    private Connection getConnectionMySql() throws Exception
    {
    	Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/AuditDb?user=root&password=WbyXs0YE";

        return DriverManager.getConnection(url);
    }
}