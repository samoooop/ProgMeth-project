package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import Interface.IDestroyable;
import Interface.IHitable;
import Interface.IRenderable;
import Interface.IUpdatable;

import java.awt.AlphaComposite;

import util.AudioUtility;
import util.Configuration;
import util.DrawingUtility;

public class Target implements IUpdatable, IRenderable, IDestroyable, IHitable {
	protected int x, y;
	protected double vel_x, vel_y;
	protected double SPEED = Configuration.SPEED;
	protected double SELECTED_SPEED = Configuration.SELECTED_SPEED;
	protected int RADIUS = Configuration.TARGET_RADIUS;
	protected boolean canHitPlayer = true;
	private boolean destroyed;
	private boolean canScore;
	private boolean isSelected;
	private int movingDelayCounter = 0;
	private int movingDelay = Configuration.TARGET_MOVING_DELAY;
	private int addTailAnimationCounter = 0;
	private int ran = RandomUtility.random(1, 5);
	public int rotatecount = 1;
	public int rotatespeed = 4;
	protected static final AlphaComposite transcluentWhite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);
	protected static final AlphaComposite opaque = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		if (isSelected) {
			canScore = true;
		}
		this.isSelected = isSelected;
	}

	public boolean isCanScore() {
		return canScore;
	}
	
	public void setCanScore(boolean b){
		canScore = b;
	}

	public Target() {
		this.randomSpawn();
	}

	public Target(int x, int y, double vel_x, double vel_y, GameScreen gs) {
		System.out.println("Spawning " + x + " " + y + " " + vel_x + " " + vel_y);
		this.x = x;
		this.y = y;
		this.vel_x = vel_x;
		this.vel_y = vel_y;
		// this.SPEED = Math.random() * 10;
		this.isSelected = false;
		this.canScore = false;
		this.canHitPlayer = true;
		
	}

	@Override
	public void update() {
		if (movingDelayCounter >= movingDelay) {
			if (addTailAnimationCounter >= Configuration.TAIL_ANIMATION_DELAY) {
				new TargetTailAnimation(x, y);
				addTailAnimationCounter = 0;
			}
			addTailAnimationCounter++;
			changePosition();
			movingDelayCounter = 0;
		}
		movingDelayCounter++;
		if (x < 0 || x > Configuration.screenWidth || y < 0 || y > Configuration.screenHeight) {
			this.destroyed = true;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadius() {
		return this.RADIUS;
	}

	@Override
	public void draw(Graphics2D g2) {
		DrawingUtility.drawCircle(g2, x, y, RADIUS, RADIUS, Color.YELLOW, Color.ORANGE);
		DrawingUtility.drawMeteo(g2, x - DrawingUtility.meteo1.getWidth() / 2, y - DrawingUtility.meteo1.getWidth() / 2,
				this.ran, rotatecount);
		rotatecount += rotatespeed;
		if (rotatecount >= 360) {
			rotatecount = 0;
		}
		if (isSelected) {
			g2.setComposite(transcluentWhite);
			g2.setColor(Color.RED);
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

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public boolean isMouseOver() {

		Point p = InputUtility.getMouseLocation();
		if (p != null && p.getX() > x - RADIUS && p.getX() < x + RADIUS && p.getY() > y - RADIUS
				&& p.getY() < y + RADIUS)
			return true;
		else
			return false;
	}

	public static double calculateSpeed(int x1, int x2, int y1, int y2) {
		double dist = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
		return (x2 - x1) / dist;
	}

	private void changeSpeed() {
		Point p = InputUtility.getMouseLocation();
		double dx = p.x - x;
		double dy = p.y - y;
		double ds = Math.sqrt(dx * dx + dy * dy);
		if (ds != 0) {
			vel_x = (dx * dx) / (ds * ds);
			vel_y = (dy * dy) / (ds * ds);
			if (dx < 0)
				vel_x = -vel_x;
			if (dy < 0)
				vel_y = -vel_y;
		}
	}

	private void changeSpeed(int xf, int yf) {
		double dx = xf - x;
		double dy = yf - y;
		double ds = Math.sqrt(dx * dx + dy * dy);
		if (ds != 0) {
			vel_x = (dx * dx) / (ds * ds);
			vel_y = (dy * dy) / (ds * ds);
			if (dx < 0)
				vel_x = -vel_x;
			if (dy < 0)
				vel_y = -vel_y;
		}
	}

	private void changePosition() {
		Point p = InputUtility.getMouseLocation();
		if (isSelected) {
			changeSpeed();
			if (Math.abs(p.x - x) <= Math.abs(vel_x * SELECTED_SPEED)) {
				x = p.x;
			} else {
				x += vel_x * SELECTED_SPEED;
			}
			if (Math.abs(p.y - y) <= Math.abs(vel_y * SELECTED_SPEED)) {
				y = p.y;
			} else {
				y += vel_y * SELECTED_SPEED;
			}
		} else {
			x += vel_x * SPEED;
			y += vel_y * SPEED;
		}

	}

	private void randomSpawn() {
		int ranFactor = (int) (Math.random() * 10000) % 4;
		switch (ranFactor) {
		case 0: // spawn from EAST
			x = 0;
			y = (int) (Math.random() * 10000) % Configuration.screenHeight;
			break;
		case 1: // spawn from WEST
			x = Configuration.screenWidth;
			y = (int) (Math.random() * 10000) % Configuration.screenHeight;
			break;
		case 2: // spawn from NORTH
			x = (int) (Math.random() * 10000) % Configuration.screenWidth;
			y = 0;
			break;
		default: // spawn from SOUTH
			x = (int) (Math.random() * 10000) % Configuration.screenWidth;
			y = Configuration.screenHeight;
			break;
		}
		changeSpeed(Configuration.screenWidth / 2, Configuration.screenHeight / 2);
	}

	public static double calculateDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

	@Override
	public boolean hit(int x, int y, int r) {
		if (calculateDistance(x, y, this.x, this.y) < RADIUS + r) {
			this.destroyed = true;
			return true;
		}
		return false;
	}

	public void destroy() {
		this.setDestroyed(true);
		AudioUtility.playSound(AudioUtility.flipSound);
		if (canScore) {
			AudioUtility.playSound(AudioUtility.clickSound);
			new ScoreAnimation(x,y);
			Player.getInstance().addScore(Configuration.TARGET_HIT_SCORE);
		}
		RenderableHolder.addFront(new HitAnimation(x, y, 1));

	}
}
