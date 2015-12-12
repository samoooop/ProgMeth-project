package Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class DrawingUtility_OLD {
	
	private static GameScreen gameScreen;
	public static Color BACKGROUND_COLOR = Color.DARK_GRAY;
	
	public static void setGameScreen(GameScreen gs){
		gameScreen = gs;
	}
	public static double getWidthResizeFactor(){
		if(gameScreen == null){
			return 1;
		}else{
			return gameScreen.getWidth()*1.0/GameScreen.screenWidth;
		}
	}
	public static double getHeightResizeFactor(){
		if(gameScreen == null){
			return 1;
		}else{
			return gameScreen.getHeight()*1.0/GameScreen.screenHeight;
		}
	}
	public static void drawCircle(Graphics2D g2,int x,int y,int innerRadius,int outterRadius,Color innerColor,Color outterColor){
		//double wrf = getWidthResizeFactor();
		//double hrf = getHeightResizeFactor();
		//int oh = (int)(outterRadius*wrf);
		//int ow = (int)(outterRadius*)
		//int ir = (int)(innerRadius*hrf)
		//x*=wrf;
		//y*=hrf;
		//g2.scale(getWidthResizeFactor(), getHeightResizeFactor());
		//System.out.println(x + " " + getWidthResizeFactor() + " " + getHeightResizeFactor() + " " +(gameScreen==null));
		g2.setColor(outterColor);
		g2.fillOval(x - outterRadius, y - outterRadius, outterRadius * 2, outterRadius * 2);
		g2.setColor(innerColor);
		g2.fillOval(x - innerRadius, y - innerRadius , innerRadius *2, innerRadius *2);
	}
	public static void drawCircle_2(Graphics2D g2,int x,int y,int stroke){
		
	}
	public static void drawCenteredString(Graphics2D g, String text, Rectangle rect, Font font) {
	    g.setColor(Color.BLACK);
		// Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(font);
	    // Determine the X coordinate for the text
	    int x = (rect.width - metrics.stringWidth(text)) / 2;
	    // Determine the Y coordinate for the text
	    int y = ((rect.height - metrics.getHeight()) / 2) - metrics.getAscent();
	    // Set the font
	    g.setFont(font);
	    // Draw the String
	    g.drawString(text, x, y);
	    // Dispose the Graphics
	    //g.dispose();
	}
}
