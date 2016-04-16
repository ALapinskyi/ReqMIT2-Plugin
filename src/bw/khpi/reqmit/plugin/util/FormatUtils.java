package bw.khpi.reqmit.plugin.util;

public class FormatUtils {
	
	public static String convertPath(String oldString){
		String newString = "";
		newString = "\\" + oldString.replace("/", "\\");
		return newString;
	}

}
