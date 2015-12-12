package Game;

import java.awt.Color;
import java.awt.Graphics2D;

import render.IRenderable;
import util.Configuration;
import util.DrawingUtility;

public class ScoreAnimation implements IRenderable,Destroyable {

	private int x;
	private int y;
	private static final int MAX_LIFE  = Configuration.MAX_LIFE; // life in ticks
	private int life = 0;
	
	public ScoreAnimation(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean isDestroyed() {
		return life > MAX_LIFE;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.setFont(DrawingUtility.drawFont.deriveFont(30f));
		g.drawString("score! +"+Configuration.TARGET_HIT_SCORE,x,y);
		life++;
		
	}
	
}
