import java.awt.Color;
import java.awt.Graphics2D;

import render.IRenderable;

public class Target implements Updatable, IRenderable, Destroyable {
	private int x, y;
	private double vel_x, vel_y;
	private double SPEED = 10;
	private int RADIUS = 20;
	private GameScreen gs;
	boolean isDestroyed;

	public Target(int x, int y) {
		this.x = x;
		this.y = y;
		isDestroyed = false;

	}

	public Target(int x, int y, double vel_x, double vel_y, GameScreen gs) {
		System.out.println("Spawning "+x+" "+y+" "+vel_x+" "+vel_y);
		this.x = x;
		this.y = y;
		this.vel_x = vel_x;
		this.vel_y = vel_y;
		this.SPEED = Math.random() * 10;
		this.gs = gs;
	}

	@Override
	public void update() {
		x += vel_x * SPEED;
		y += vel_y * SPEED;
		if (x < 0 || x > gs.getWidth() || y < 0 || y > gs.getHeight()) {
			isDestroyed = true;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.fillOval(x - RADIUS, y - RADIUS, RADIUS, RADIUS);
	}

	public boolean isOutOfScreen(int screenWidth, int screenHeight) {
		if (x < 0 || x > screenWidth || y < 0 || y > screenHeight) {
			return true;
		}
		return false;
	}

	public boolean isDestroyed() {
		return isDestroyed;
	}

}
