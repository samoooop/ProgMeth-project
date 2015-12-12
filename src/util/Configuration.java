
package util;

public class Configuration {
	
	public static int screenWidth = 1200;
	public static int screenHeight = 800;
	
	public static int animationFrameCount = 10;
	
	//GameLogic Configuration
	public static final int SPAWN_DELAY = 20;
	public static final int TIME_PER_TICK = 20; // mils per tick
	
	//Target Configuration
	public static double SPEED = 5; // per tick
	public static double SELECTED_SPEED = 10;
	public static int TARGET_RADIUS = 20;
	public static int TARGET_MOVING_DELAY = 1; // increase will result in target move laggy
}
