package bw.khpi.reqmit.plugin.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitMap  {
	
	private static Map<String, UnitStructure> unitMap = new HashMap<String, UnitStructure>();
	
	private UnitMap(){
		
	}
	
	public static Map<String, UnitStructure> getUnits() {
		return unitMap;
	}
	
	public static void addUnit(String key, UnitStructure value) {
		unitMap.put(key, value);
	}
	
	public static void removeUnit(String key) {
		unitMap.remove(key);
	}
	
	public static void removeAll() {
		unitMap.clear();
	}
	
}
