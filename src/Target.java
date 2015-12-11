import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.AlphaComposite;

import render.IRenderable;

public class Target implements Updatable, IRenderable, Destroyable {
	private int x, y;
	private double vel_x, vel_y;
	private double SPEED = 10;
	private int RADIUS = 15;
	private GameScreen gs;
	boolean isDestroyed;
	private Line path;
	private boolean isSelected;
	private int currentPoint;
	private int movingDelay = 2;
	private int movingDelayCounter;

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
		this.movingDelayCounter = 0;
	}

	@Override
	public void update() {
		if (path == null) {
			x += vel_x * SPEED;
			y += vel_y * SPEED;
		} else {
			if (movingDelayCounter == movingDelay) {
				changeSpeed();
				changePosition();
				movingDelayCounter = 0;
			}
			movingDelayCounter++;
		}
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
		if (path != null) {
			path.draw(g2);
		}
		g2.setColor(Color.BLUE);
		g2.fillOval(x - RADIUS, y - RADIUS, RADIUS * 2, RADIUS * 2);
		if (isSelected) {
			g2.setComposite(transcluentWhite);
			g2.setColor(Color.YELLOW);
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

	public void addPointToPath(Point p, boolean isNewLine) {
		if (path == null || isNewLine) {
			path = new Line();
			currentPoint = 0;
			path.addPoint(new Point(x, y));
		}
		path.addPoint(p);
	}

	public static double calculateSpeed(int x1, int x2, int y1, int y2) {
		double dist = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
		return (x2 - x1) / dist;
	}

	private void changeSpeed() {
		double new_vel_x = calculateSpeed(x,path.getIndex(currentPoint).x, y,
				(int) path.getIndex(currentPoint).y);
		double new_vel_y = calculateSpeed(y,path.getIndex(currentPoint).y, x,
				(int) path.getIndex(currentPoint).x);
		System.out.println(vel_x+" "+vel_y);
		if (new_vel_x + new_vel_y > 0.8) {
			vel_x = new_vel_x;
			vel_y = new_vel_y;
		}
	}

	private void changePosition() {
		x = path.getIndex(currentPoint).x;
		y = path.getIndex(currentPoint).y;
		if (currentPoint == path.getSize() - 1) { // last point in line
			if (!isSelected) {
				path = null;
			}
		}
		currentPoint++;
	}
}
