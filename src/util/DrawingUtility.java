package util;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Game.GameScreen;
public class DrawingUtility {
	
	public static final int STATE_NORMAL = 0;
	public static final int STATE_HOVER = 1;
	public static final int STATE_CLICK = 2;
	
	private static GameScreen gameScreen;
	public static Color BACKGROUND_COLOR = Color.DARK_GRAY;
	
	public static final BufferedImage gameBG = loadImage("res/img/mybackground.png");
	public static final BufferedImage gameSetting = loadImage("res/img/settingsButton.png");
	public static final BufferedImage soundOff = loadImage("res/img/soundOffButton.png");
	public static final BufferedImage soundOn = loadImage("res/img/soundOnButton.png");
	public static final BufferedImage aboutButton = loadImage("res/img/aboutButton.png");
	public static final BufferedImage undoButton = loadImage("res/img/undoButton.png");
	public static final BufferedImage settingsButtonImg = loadImage("res/img/settingsButton.png");
	public static final BufferedImage playButtonImg = loadImage("res/img/playButton.png");
	public static final BufferedImage earth2 = loadImage("res/img/earth.png");
	public static final BufferedImage fireball2 = loadImage("res/img/fireball.png");
	public static final BufferedImage myframe2 = loadImage("res/img/myframe2.png");
	public static Image dimg =  DrawingUtility.gameBG.getScaledInstance(Config.screenWidth, Config.screenHeight,
	        Image.SCALE_SMOOTH);
	public static Image earth =  DrawingUtility.earth2.getScaledInstance(300, 300,
	        Image.SCALE_SMOOTH);
	public static Image fireball =  DrawingUtility.fireball2.getScaledInstance(115, 80,
	        Image.SCALE_SMOOTH);
	public static Image myframe =  DrawingUtility.myframe2.getScaledInstance(Config.screenWidth, Config.screenHeight,
	        Image.SCALE_SMOOTH);
    
	
	
	
	
	private static BufferedImage loadImage(String directory){
		BufferedImage a  ;
		try{
			ClassLoader load = DrawingUtility.class.getClassLoader();
			a = ImageIO.read(load.getResource(directory));
		}catch(Exception e){a = null;}
	return a;
	}
	public static BufferedImage getClickableImg(BufferedImage imagerow, int state){
		if(state < 3)
			return imagerow.getSubimage(imagerow.getWidth() * state / 3, 0, imagerow.getWidth() / 3, imagerow.getHeight());
		else return null;
	}
	
	
	
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
