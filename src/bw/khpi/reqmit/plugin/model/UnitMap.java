package bw.khpi.reqmit.plugin.model;

import java.util.HashMap;
import java.util.Map;

public class UnitMap  {
	
	private static Map<WorkspaceUnit, Event> unitMap = new HashMap<WorkspaceUnit, Event>();
	
	private UnitMap(){
		
	}
	
	public static Map<WorkspaceUnit, Event> getUnits() {
		return unitMap;
	}
	
	public static void addUnit(WorkspaceUnit key, Event value) {
		unitMap.put(key, value);
	}
	
	public static void removeUnit(WorkspaceUnit key) {
		unitMap.remove(key);
	}
	
	public static void removeAll() {
		unitMap.clear();
	}
	
}
