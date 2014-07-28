package com.paulsamiq.jersey2akka;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LogMessage {
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public LogMessage()
	{
		
	}
	
	public LogMessage(String title)
	{
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Log Message [title=" + title + "]";
	}
}
