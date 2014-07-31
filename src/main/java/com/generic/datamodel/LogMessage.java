package com.generic.datamodel;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LogMessage implements Serializable {
	private static final long serialVersionUID = 1760154203906810594L;
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
