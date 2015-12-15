
package util;

import java.awt.AlphaComposite;
import java.awt.Color;

public class Configuration {

	public static int screenWidth = 1600;
	public static int screenHeight = 900;

	public static int animationFrameCount = 10;

	// Drawing Util
	public static final float FONT_SIZE = 60f;
	public static final String FONT_NAME = "ROCKETMAN.TTF"; // best is
															// "digital-7.ttf"
	public static final AlphaComposite transcluentWhite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);
	public static final AlphaComposite opaque = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);

	// GameLogic Configuration
	public static final int SPAWN_DELAY_TITLE = 100;
	public static final int SPAWN_DELAY_GAME = 50;
	public static int SPAWN_DELAY = 50;
	public static final int TIME_PER_TICK = 20; // mils per tick

	// Target Configuration
	public static double SPEED = 5; // per tick
	public static double SELECTED_SPEED = 7;
	public static int TARGET_RADIUS = 40;
	public static int TARGET_RADIUS_GAME = 40;
	public static int TARGET_RADIUS_TITLE = 40;
	public static int TARGET_MOVING_DELAY = 1; // increase will result in target move laggy
	public static int TAIL_ANIMATION_DELAY = 5;
	public static boolean TARGET_HIT_SOUND_EFFECT = true;
	

	// Player Config
	public static Color PLAYER_COLOR = Color.GREEN;
	public static final double REGEN_SPEED_DEFAULT = 0.005;
	public static double REGEN_SPEED = 0.005;
	public static boolean SHOW_HIT_EFFECT = true;
	public static int HIT_EFFECT_TYPE = 2; // 1:full screen 2:only player
	public static int TARGET_HIT_SCORE = 10000;
	public static final int PLAYER_RADIUS = 150;
	public static int HEALTH_BAR_MAX_WIDTH = 500;
	public static int HEALTH_BAR_MAX_HEIGHT = 50;
	public static int HEALTH_BAR_THICK = 10;
	public static double MAX_HIT_POINT = 200;
	public static int HIT_DAMAGE = 5;
	public static boolean canUseSkill = true;
	public static boolean DRAW_HAT = true;
	public static boolean DRAW_GLASS = true;
	public static boolean DRAW_HEALTH_BAR = true;
	public static boolean DRAW_SCORE = true;
	public static final double SKILL_HEALTH_PERCENT_USAGE = 25;

	// ScoreAnimation
	public static final int MAX_LIFE = 100;

	// Tail Animation
	public static final int TAIL_MAX_RADIUS = TARGET_RADIUS;
	public static final int TAIL_MIN_RADIUS = 0;
	public static final double TAIL_RADIUS_REDUCE_RATE = 0.5;
	public static final boolean ENABLE_ANTIALLIASING = false;
	
	//UI configuration
	public static final int HEALTH_BAR_SCREEN_OFFSET =10;
	public static final int SCORE_SCREEN_OFFSET = 10;
	public static final float HEALTH_BAR_FONT_SIZE = FONT_SIZE - 15f;

}
