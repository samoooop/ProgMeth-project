import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.AlphaComposite;

import render.IRenderable;

public class Target implements Updatable, IRenderable, Destroyable {
	private int x, y;
	private double vel_x, vel_y;
	private double SPEED = 10;
	private int RADIUS = 10;
	private GameScreen gs;
	boolean isDestroyed;
	private Line path;
	private boolean isSelected;

	protected static final AlphaComposite transcluentWhite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);
	protected static final AlphaComposite opaque = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public Target(int x, int y, double vel_x, double vel_y, GameScreen gs) {
		System.out.println("Spawning " + x + " " + y + " " + vel_x + " " + vel_y);
		this.x = x;
		this.y = y;
		this.vel_x = vel_x;
		this.vel_y = vel_y;
		this.SPEED = Math.random() * 10;
		this.gs = gs;
		this.isSelected = false;
		this.path = null;
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
		g2.setColor(Color.BLUE);
		g2.fillOval(x - RADIUS, y - RADIUS, RADIUS * 2, RADIUS * 2);
		if (isSelected) {
			System.out.println("Select");
			g2.setComposite(transcluentWhite);
			g2.setColor(Color.BLACK);
			g2.fillOval(x - RADIUS, y - RADIUS, RADIUS * 2, RADIUS * 2);
			g2.setComposite(opaque);
		} else if (isMouseOver()) {
			g2.setComposite(transcluentWhite);
			g2.setColor(Color.WHITE);
			g2.fillOval(x - RADIUS, y - RADIUS, RADIUS * 2, RADIUS * 2);
			g2.setComposite(opaque);
		}

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

	public boolean isMouseOver() {

		Point p = InputUtility.getMouseLocation();
		if (p != null && p.getX() > x - RADIUS && p.getX() < x + RADIUS && p.getY() > y - RADIUS
				&& p.getY() < y + RADIUS)
			return true;
		else
			return false;
	}
}
