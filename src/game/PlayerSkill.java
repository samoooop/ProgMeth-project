package game;

import java.awt.Color;
import java.awt.Graphics2D;

import util.Configuration;

public class PlayerSkill extends Target {
	// private int RADIUS = Configuration.PLAYER_RADIUS;
	private int MAX_RADIUS = Math.max(Configuration.screenWidth/2,Configuration.screenHeight/2);
	private int RADIUS_INCREASE_RATE = 50;

	public PlayerSkill() {
		super();
		this.x = Configuration.screenWidth/2;
		this.y = Configuration.screenHeight/2;
		this.vel_x = 0;
		this.vel_y = 0;
		this.RADIUS = Configuration.PLAYER_RADIUS;
		this.canHitPlayer = false;
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.setComposite(Configuration.transcluentWhite);
		g2.setColor(Color.BLUE);
		g2.fillOval(x - RADIUS, y - RADIUS, RADIUS * 2, RADIUS * 2);
		g2.setComposite(Configuration.opaque);

	}

	@Override
	public boolean isDestroyed() {
		if (RADIUS > MAX_RADIUS)
			return true;
		return false;
	}

	@Override
	public boolean hit(int x, int y, int r) {
		if (Target.calculateDistance(x, y, this.x, this.y) > r + this.RADIUS)
			return true;
		return false;
	}

	@Override
	public void update() {
		RADIUS += RADIUS_INCREASE_RATE;
	}

	@Override
	public void destroy() {

	}
}
