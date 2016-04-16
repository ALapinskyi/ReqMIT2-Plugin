package bw.khpi.reqmit.plugin.util;

import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
	
	public static Date getCurrentTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

}
