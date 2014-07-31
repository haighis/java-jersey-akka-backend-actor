package com.generic.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.generic.datamodel.LogMessage;

public class LogService {
	
	public LogService() throws Exception
	{
		
	}
	
	public void SaveMessage(LogMessage logMessage) throws Exception
	{
		Connection conn = getConnectionMySql();
		
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("INSERT INTO LogMessage (message) VALUES('" + logMessage.getTitle() +"');");

	    stmt.close();
	    conn.close();
	}
	
    private Connection getConnection() throws Exception {
        Class.forName("org.hsqldb.jdbcDriver");
        String url = "jdbc:hsqldb:mem:data/tutorial";

        return DriverManager.getConnection(url, "sa", "");
      }
	
	private Connection getConnectionMySql() throws Exception
    {
    	Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/AuditDb?user=root&password=arui69NOW";

        return DriverManager.getConnection(url);
    }
}
