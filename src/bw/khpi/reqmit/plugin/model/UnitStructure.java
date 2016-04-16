package bw.khpi.reqmit.plugin.model;

import java.util.List;

public class UnitStructure {
	
	private WorkspaceUnit unit;
	private List<Event> events;
	
	public UnitStructure(WorkspaceUnit unit, List<Event> events) {
		this.unit = unit;
		this.events = events;
	}

	public WorkspaceUnit getUnit() {
		return unit;
	}

	public void setUnit(WorkspaceUnit unit) {
		this.unit = unit;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
