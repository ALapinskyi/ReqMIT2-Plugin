package bw.khpi.reqmit.plugin.model;

import java.util.Date;

public class Event {
	
	private Date eventTime;
	private EventType eventType;
	
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
