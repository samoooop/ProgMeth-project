package Game;

import java.awt.Color;
import java.awt.Graphics2D;

import render.IRenderable;
import util.Configuration;
import util.DrawingUtility;
import util.TimeUtility;

public class Player implements IRenderable, Hitable {

	@SuppressWarnings("unused")
	private Color PLAYER_COLOR = Color.GREEN;
	private int x = Configuration.screenWidth / 2;
	private int y = Configuration.screenHeight / 2;
	public static int RADIUS = 150;
	private long score = 0;
	private static final Player instance = new Player();
	private double hitPoint = 100;
	private double MAX_HIT_POINT = 100;
	private boolean dead = false;
	public static int hitDamage = 5;
	private double hitPointRegenRate = Configuration.REGEN_SPEED;

	private int HEALTH_BAR_MAX_WIDTH = 500;
	private int HEALTH_BAR_MAX_HEIGHT = 40;
	private int HEALTH_BAR_THICK = 5;
	
	private boolean hit = false;

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
		g2.drawImage(util.DrawingUtility.earth, Configuration.screenWidth / 2 - 150, Configuration.screenHeight / 2 - 150, null);
		drawHealthBar(g2);
		drawScore(g2);
		if(hit && Configuration.SHOW_HIT_EFFECT){
			System.out.println("im hit");
			DrawingUtility.drawHit(g2);
		}
	}

	public void update() {
		if (!dead) {
			regen();
		}
		hit = false;
	}

	@Override
	public boolean hit(int x, int y, int r) {
		double dist = Target.calculateDistance(this.x, this.y, x, y);
		if (Player.RADIUS + r > dist) {
			hit = true;
			reduceHitPoint(hitDamage);
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
		return 1.0 * hitPoint * 100 / MAX_HIT_POINT;
	}

	public void reduceHitPoint(int d) {
		hitPoint -= d;
		if (hitPoint < 0) {
			hitPoint = 0;
			dead = true;
		}

	}

	public void regen() {
		hitPoint += hitPointRegenRate;
		if (hitPoint > MAX_HIT_POINT)
			hitPoint = MAX_HIT_POINT;
	}

	public int getX() {
		return 0;
	}

	public int getY() {
		return 0;
	}

	private void drawHealthBar(Graphics2D g2) {
		g2.setColor(Color.GRAY);
		g2.fillRect(0, Configuration.screenHeight - HEALTH_BAR_MAX_HEIGHT - HEALTH_BAR_THICK * 2,
				HEALTH_BAR_MAX_WIDTH + HEALTH_BAR_THICK * 2, HEALTH_BAR_MAX_HEIGHT + HEALTH_BAR_THICK * 2);
		g2.setColor(Color.BLACK);
		g2.fillRect(0 + HEALTH_BAR_THICK, Configuration.screenHeight - HEALTH_BAR_MAX_HEIGHT - HEALTH_BAR_THICK,
				HEALTH_BAR_MAX_WIDTH, HEALTH_BAR_MAX_HEIGHT);

		g2.setColor(Color.RED);
		g2.fillRect(0 + HEALTH_BAR_THICK, Configuration.screenHeight - HEALTH_BAR_MAX_HEIGHT - HEALTH_BAR_THICK,
				(int) (getPercentHitPoint() * HEALTH_BAR_MAX_WIDTH / 100.0), HEALTH_BAR_MAX_HEIGHT);

		if (!dead) {
			g2.setColor(Color.YELLOW);
			g2.setFont(DrawingUtility.drawFont);
			g2.drawString(String.format("%.2f ", getPercentHitPoint())+"%", 0 + HEALTH_BAR_THICK,
					Configuration.screenHeight - HEALTH_BAR_THICK*2);
		} else {
			g2.setColor(Color.RED);
			g2.setFont(DrawingUtility.drawFont);
			g2.drawString(String.format("	YOU ARE DEAD"), 0 + HEALTH_BAR_THICK,
					Configuration.screenHeight - HEALTH_BAR_THICK*2);
		}

	}

	public void drawScore(Graphics2D g) {
		String s = String.format("SCORE : %010d", getScore());
		g.setFont(DrawingUtility.drawFont);
		g.setColor(Color.WHITE);
		g.drawString(s, Configuration.screenWidth - g.getFontMetrics().stringWidth(s), Configuration.screenHeight - HEALTH_BAR_THICK);

	}

	public boolean isDead() {
		return dead;
	}

}
