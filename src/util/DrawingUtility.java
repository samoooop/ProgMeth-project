package util;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
public class DrawingUtility {
	
	public static final int STATE_NORMAL = 0;
	public static final int STATE_HOVER = 1;
	public static final int STATE_CLICK = 2;
	
	
	public static final BufferedImage gameBG = loadImage("res/img/mybackground.png");
	public static final BufferedImage gameSetting = loadImage("res/img/settingsButton.png");
	public static final BufferedImage soundOff = loadImage("res/img/soundOffButton.png");
	public static final BufferedImage soundOn = loadImage("res/img/soundOnButton.png");
	public static final BufferedImage aboutButton = loadImage("res/img/aboutButton.png");
	public static final BufferedImage undoButton = loadImage("res/img/undoButton.png");
	public static final BufferedImage settingsButtonImg = loadImage("res/img/settingsButton.png");
	public static final BufferedImage playButtonImg = loadImage("res/img/playButton.png");
	public static final BufferedImage earth2 = loadImage("res/img/earth.png");

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
}
