import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import render.IRenderable;

public class Player implements IRenderable, Hitable {

	private Color PLAYER_COLOR = Color.GREEN;
	private int x = GameScreen.screenWidth / 2;
	private int y = GameScreen.screenHeight / 2;
	public static int RADIUS = 50;
	private long score = 0;
	private static final Player instance = new Player();
	private double hitPoint = 100;
	private double MAX_HIT_POINT = 100;
	private boolean dead = false;
	public static int hitDamage = 5;
	private double hitPointRegenRate = 0.1;

	private int HEALTH_BAR_MAX_WIDTH = 500;
	private int HEALTH_BAR_MAX_HEIGHT = 40;

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
		DrawingUtility.drawCircle(g2, x, y, 0, Player.RADIUS, Color.BLACK, PLAYER_COLOR);
		drawHealthBar(g2);
		// System.out.println(x-RADIUS);
		// DrawingUtility.drawCenteredString(g2, this.getPercentHitPoint()+"%",
		// new Rectangle(this.x-RADIUS,this.y-RADIUS,RADIUS*2,RADIUS*2), new
		// Font(Font.SANS_SERIF,0,20));
		// g2.setFont(new Font(Font.SANS_SERIF,0,20));
		// g2.setColor(Color.BLACK);
		// 1g2.drawString(this.getPercentHitPoint()+"%", x, y);
	}

	public void update() {
		if (!dead)
			regen();
	}

	@Override
	public boolean hit(int x, int y, int r) {
		double dist = Target.calculateDistance(this.x, this.y, x, y);
		if (Player.RADIUS + r > dist) {
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
		return score;
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
		// TODO Auto-generated method stub
		return 0;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void drawHealthBar(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.fillRect(0, GameScreen.screenHeight - HEALTH_BAR_MAX_HEIGHT,
				(int) (getPercentHitPoint() * HEALTH_BAR_MAX_WIDTH / 100.0), HEALTH_BAR_MAX_HEIGHT);
		g2.setColor(Color.BLACK);
		g2.setFont(new Font(Font.SANS_SERIF, 0, HEALTH_BAR_MAX_HEIGHT));
		g2.drawString(getPercentHitPoint() + " %", 0, GameScreen.screenHeight);
	}

}
