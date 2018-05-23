package ch.bbcag.DeLoreanLander.util;

public class TimeUtil {

	private static long startTime;

	public static long getStartTime() {
		return startTime;
	}

	public static void setStartTime(long startTime) {
		TimeUtil.startTime = startTime;
	}
}