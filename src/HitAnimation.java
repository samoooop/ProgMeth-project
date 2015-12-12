import java.awt.Color;
import java.awt.Graphics2D;

import render.IRenderable;

public class HitAnimation implements IRenderable,Destroyable {

	private static Color ANIMATION_COLOR = Color.ORANGE;
	private int x,y;
	private static int MAX_RADIUS = 40;
	private static int CIRCLE_THICK = 2;
	private static int MAX_CHAIN_TIME = 3;
	private static int CHAIN_DELAY_TIME = 100;
	private static boolean CAN_CHAIN = true; // still buggy(concurrent)
	private static int ANIMATE_SPEED = 2;
	private int time ;
	private int radius;
	private boolean destroyed;
	public HitAnimation(int x,int y,int time){
		this.destroyed = false;
		this.radius = 0;
		this.x = x;
		this.y = y;
		this.time = time;
	}
	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

	@Override
	public void draw(Graphics2D g) {
		DrawingUtility.drawCircle(g,x,y,radius,radius+CIRCLE_THICK,DrawingUtility.BACKGROUND_COLOR,ANIMATION_COLOR);
		if(radius>MAX_RADIUS){
			destroyed = true;
		}
		if(time < MAX_CHAIN_TIME && radius == CHAIN_DELAY_TIME && CAN_CHAIN){
			RenderableHolder.add(new HitAnimation(x,y,time+1));
		}
		radius += ANIMATE_SPEED;
	}

}
