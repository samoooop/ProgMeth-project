package util;

public class TimeUtility {
	public static int ESCALATED_TICK = 0;
	public static void reset(){
		ESCALATED_TICK = 0;
	}
	public static void inceaseTick(){
		ESCALATED_TICK ++;
	}
	public static int getTick(){
		return ESCALATED_TICK ;
	}
	public static int getEscalatedTime(){
		return ESCALATED_TICK * Configuration.TIME_PER_TICK;
	}
}
