package util;
import java.awt.Point;

public class InputUtility_Game {
	static private boolean mouseLeftPressed;
	static private boolean mouseLeftTriggered;
	static private Point mouseLocation = new Point(0,0);
	static private boolean mouseMoved;
	
	public static boolean isMouseLeftTriggered() {
		return mouseLeftTriggered;
	}

	public static void setMouseLeftTriggered(boolean mousLeftTriggered) {
		InputUtility_Game.mouseLeftTriggered = mousLeftTriggered;
	}

	public static void setMouseLeftDown(boolean pressed) {
		InputUtility_Game.mouseLeftPressed = pressed;
	}

	public static boolean getMouseLeftDown() {
		return mouseLeftPressed;
	}

	public static void setMouseMoved(boolean b) {
		mouseMoved = b;
	}

	public static Point getMouseLocation() {
		return mouseLocation;
	}

	public static boolean isMouseMoved() {
		return mouseMoved;
	}

	static public void update() {
		mouseMoved = false;
		mouseLeftTriggered = false;
	}

	public static void setMouseLocation(Point p) {
		mouseLocation = p;
	}
}
