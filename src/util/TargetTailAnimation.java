package util;

import java.awt.Color;
import java.awt.Graphics2D;

import Game.Destroyable;
import Game.RenderableHolder;
import render.IRenderable;

public class TargetTailAnimation implements IRenderable,Destroyable {
	private int x;
	private int y;
	
	private int min_radius = Configuration.TAIL_MIN_RADIUS;
	private double radius = Configuration.TAIL_MAX_RADIUS;
	
	public TargetTailAnimation(int x,int y){
		this.x = x;
		this.y = y;
		RenderableHolder.addFront(this);
	}
	
	@Override
	public boolean isDestroyed() {
		if(radius < min_radius){
			return true;
		}
		return false;
	}
	@Override
	public void draw(Graphics2D g2) {
		DrawingUtility.drawCircle(g2, x, y, 0, (int)radius, Color.WHITE, Color.ORANGE);
		radius -= Configuration.TAIL_RADIUS_REDUCE_RATE;
	}
	
}
