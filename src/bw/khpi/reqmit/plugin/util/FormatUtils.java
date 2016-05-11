package bw.khpi.reqmit.plugin.util;

import bw.khpi.reqmit.plugin.model.Event;
import bw.khpi.reqmit.plugin.model.UnitStructure;

public class FormatUtils {
	
	public static String convertPath(String oldString){
		String newString = "";
		newString = "\\" + oldString.replace("/", "\\");
		return newString;
	}
	
	public static String eventToJson(String path, Event event){
		String json = "";
		
		json += "{\"file\":" + path;
		json += ",\"event\":" + event.getEventType();
		json += ",\"time\":" + event.getEventTime();
		json += "\"}";
		
		return json;
	}

}
