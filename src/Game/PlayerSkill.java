package Game;

import java.awt.Color;
import java.awt.Graphics2D;

import util.Configuration;

public class PlayerSkill extends Target {
	private int x = Configuration.screenWidth / 2;
	private int y = Configuration.screenHeight / 2;
	private int radius = Configuration.PLAYER_RADIUS;
	private int MAX_RADIUS = Configuration.screenWidth;
	private int RADIUS_INCREASE_RATE = 30;

	@Override
	public void draw(Graphics2D g2) {
		g2.setComposite(Configuration.transcluentWhite);
		g2.setColor(Color.BLUE);
		g2.fillOval(x - radius, y - radius, radius * 2, radius * 2);
		g2.setComposite(Configuration.opaque);

	}

	@Override
	public boolean isDestroyed() {
		if (radius > MAX_RADIUS)
			return true;
		return false;
	}

	@Override
	public boolean hit(int x, int y, int r) {
		if (Target.calculateDistance(x, y, this.x, this.y) > r + this.radius)
			return true;
		return false;
	}

	@Override
	public void update() {
		radius += RADIUS_INCREASE_RATE;
	}
	
	@Override
	public void destroy(){
		
	}
}
