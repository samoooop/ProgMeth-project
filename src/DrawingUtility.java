import java.awt.Color;
import java.awt.Graphics2D;

public class DrawingUtility {
	
	private static GameScreen gameScreen;
	public static Color BACKGROUND_COLOR = Color.DARK_GRAY;
	
	public static void setGameScreen(GameScreen gs){
		gameScreen = gs;
	}
	public static double getWidthResizeFactor(){
		if(gameScreen == null){
			return 1;
		}else{
			return gameScreen.getWidth()/GameScreen.screenWidth;
		}
	}
	public static double getHeightResizeFactor(){
		if(gameScreen == null){
			return 1;
		}else{
			return gameScreen.getWidth()/GameScreen.screenHeight;
		}
	}
	public static void drawCircle(Graphics2D g2,int x,int y,int innerRadius,int outterRadius,Color innerColor,Color outterColor){
		x*=getWidthResizeFactor();
		y*=getHeightResizeFactor();
		g2.setColor(outterColor);
		g2.fillOval(x - outterRadius, y - outterRadius, outterRadius * 2, outterRadius * 2);
		g2.setColor(innerColor);
		g2.fillOval(x - innerRadius, y - innerRadius , innerRadius *2, innerRadius *2);
	}
	public static void drawCircle_2(Graphics2D g2,int x,int y,int stroke){
		
	}
}
