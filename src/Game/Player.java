package Game;

import java.awt.Graphics2D;
import render.IRenderable;
import util.Configuration;
import util.DrawingUtility;
import util.TimeUtility;

public class Player implements IRenderable, Hitable {

	private int x = Configuration.screenWidth / 2;
	private int y = Configuration.screenHeight / 2;
	public static int RADIUS = Configuration.PLAYER_RADIUS;
	private long score = 0;
	private static Player instance = new Player();
	private double hitPoint = Configuration.MAX_HIT_POINT;
	private boolean dead = false;
	public boolean useSkill = false;

	private boolean hit = false;

	public static void reset() {
		instance = new Player();
	}

	public static Player getInstance() {

		return instance;
	}

	private boolean pause = false;

	public void setPause(boolean b) {
		pause = b;
	}

	public boolean isPause() {
		return pause;
	}

	@Override
	public void draw(Graphics2D g2) {
		DrawingUtility.drawPlayer(g2);
		DrawingUtility.drawHealthBar(g2);
		DrawingUtility.drawScore(g2);
		if (hit && Configuration.SHOW_HIT_EFFECT) {
			DrawingUtility.drawHit(g2);
		}
	}

	public void update() {
		if (!dead) {
			regen();
		}
		hit = false;
		useSkill = false;
	}

	@Override
	public boolean hit(int x, int y, int r) {
		double dist = Target.calculateDistance(this.x, this.y, x, y);
		if (Player.RADIUS + r > dist) {
			hit = true;
			reduceHitPoint(Configuration.HIT_DAMAGE);
			return true;
		}
		return false;
	}

	public void addScore(int s) {
		score += s;
	}

	public void setScore(int s) {
		score = s;
	}

	public long getScore() {
		return score + TimeUtility.getEscalatedTime();
	}

	public double getPercentHitPoint() {
		return 1.0 * hitPoint * 100 / Configuration.MAX_HIT_POINT;
	}

	public void reduceHitPoint(int d) {
		hitPoint -= d;
		if (hitPoint < 0) {
			hitPoint = 0;
			dead = true;
		}

	}

	public void regen() {
		hitPoint += Configuration.REGEN_SPEED;
		if (hitPoint > Configuration.MAX_HIT_POINT)
			hitPoint = Configuration.MAX_HIT_POINT;
	}

	public int getX() {
		return 0;
	}

	public int getY() {
		return 0;
	}

	public boolean isDead() {
		return dead;
	}

}
