package bw.khpi.reqmit.plugin.model;

import java.util.Calendar;
import java.util.Date;

public class Event {
	
	private Date eventTime;
	private EventType eventType;
	
	public Event(Date eventTime, EventType eventType) {
		super();
		this.eventTime = eventTime;
		this.eventType = eventType;
	}
	public Date getEventTime() {
		return eventTime;
	}
	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
	public EventType getEventType() {
		return eventType;
	}
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	
	

}
