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
}
