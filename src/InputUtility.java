import java.awt.Point;

public class InputUtility {
	static private boolean mouseLeftPressed;
	static private boolean mouseLeftTriggered;
	public static boolean isMouseLeftTriggered() {
		return mouseLeftTriggered;
	}
	public static void setMouseLeftTriggered(boolean mousLeftTriggered) {
		InputUtility.mouseLeftTriggered = mousLeftTriggered;
	}
	static public Point mouseLocation;
	static public boolean mouseMoved;
	public static void setMouseLeftDown(boolean pressed){
		InputUtility.mouseLeftPressed = pressed;
	}
	public static boolean getMouseLeftDown(){
		return mouseLeftPressed;
	}
	public static void setMouseMoved(Point p){
		mouseMoved = true;
		mouseLocation = p;
	}
	public static Point getMouseLocation() {
		return mouseLocation;
	}
	public static boolean isMouseMoved() {
		return mouseMoved;
	}
	static public void update(){
		mouseMoved = false;
	}
	
}
