package util;

import java.util.Date;

public class TimeUtility {
	private static Date initDate;
	private static Date endDate;

	public static void reset() {
		initDate = new Date();
		endDate = null;
	}

	public static long getEscalatedTime() {
		if (initDate == null) {
			initDate = new Date();
			endDate = null;
		}
		Date now = new Date();
		if (endDate == null) {
			return now.getTime() - initDate.getTime();
		}
		else{
			return endDate.getTime() - initDate.getTime();
		}
	}

	public static void end() {
		if (endDate == null)
			endDate = new Date();
	}
}
