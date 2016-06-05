package bw.khpi.reqmit.plugin.model;

import java.util.Calendar;
import java.util.Date;

public class Event {
	
	private Long eventTime;
	private EventType eventType;
	
	public Event(Long eventTime, EventType eventType) {
		super();
		this.eventTime = eventTime;
		this.eventType = eventType;
	}
	public Long getEventTime() {
		return eventTime;
	}
	public void setEventTime(Long eventTime) {
		this.eventTime = eventTime;
	}
	public EventType getEventType() {
		return eventType;
	}
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	
	

}
