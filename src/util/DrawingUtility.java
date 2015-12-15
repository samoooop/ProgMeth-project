package util;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.GameScreen;
import Game.Player;
import Game.TargetSpawner;

public class DrawingUtility {

	public static final int STATE_NORMAL = 0;
	public static final int STATE_HOVER = 1;
	public static final int STATE_CLICK = 2;

	private static GameScreen gameScreen;
	public static Color BACKGROUND_COLOR = Color.DARK_GRAY;

	public static final BufferedImage gameBG = loadImage("res/img/mybackground.png");
	public static final BufferedImage gameSetting = loadImage("res/img/settingsButton.png");
	public static final BufferedImage soundOff = loadImage("res/img/soundOffButton.png");
	public static final BufferedImage soundOn = loadImage("res/img/soundOnButton.png");
	public static final BufferedImage aboutButton = loadImage("res/img/aboutButton.png");
	public static final BufferedImage backButton = loadImage("res/img/undoButton.png");
	public static final BufferedImage settingsButtonImg = loadImage("res/img/settingsButton.png");
	public static final BufferedImage playButtonImg = loadImage("res/img/playButton.png");
	public static final BufferedImage earth2 = loadImage("res/img/earth.png");
	public static final BufferedImage fireball2 = loadImage("res/img/fireball.png");
	public static final BufferedImage myframe2 = loadImage("res/img/myframe2.png");
	public static final BufferedImage glasses = loadImage("res/img/thuglife.png");

	public static final BufferedImage logoText2 = loadImage("res/img/logotext.png");
	public static BufferedImage logoText = resize(logoText2, (int) (Configuration.PLAYER_RADIUS * 3),
			(int) (Configuration.PLAYER_RADIUS / 2));

	public static final BufferedImage logo2 = loadImage("res/img/mylogo.png");
	public static BufferedImage logo = resize(logo2, (int) (Configuration.PLAYER_RADIUS * 1.5),
			(int) (Configuration.PLAYER_RADIUS * 1.5));

	public static final BufferedImage cloud11 = loadImage("res/img/cloud1.png");
	public static BufferedImage cloud1 = resize(cloud11, (int) (Configuration.PLAYER_RADIUS * 3),
			(int) (Configuration.PLAYER_RADIUS * 1));

	public static final BufferedImage cloud22 = loadImage("res/img/cloud2.png");
	public static BufferedImage cloud2 = resize(cloud22, (int) (Configuration.PLAYER_RADIUS * 2),
			(int) (Configuration.PLAYER_RADIUS * 1));

	public static final BufferedImage cloud33 = loadImage("res/img/cloud3.png");
	public static BufferedImage cloud3 = resize(cloud33, (int) (Configuration.PLAYER_RADIUS * 1.5),
			(int) (Configuration.PLAYER_RADIUS * 0.8));

	public static final BufferedImage cloud44 = loadImage("res/img/cloud4.png");
	public static BufferedImage cloud4 = resize(cloud44, (int) (Configuration.PLAYER_RADIUS * 2.7),
			(int) (Configuration.PLAYER_RADIUS * 0.8));

	public static Image thugglasses = DrawingUtility.glasses.getScaledInstance(Configuration.PLAYER_RADIUS * 2,
			Configuration.PLAYER_RADIUS + Configuration.PLAYER_RADIUS / 2, Image.SCALE_SMOOTH);
	public static final BufferedImage hatb = loadImage("res/img/obey.png");
	public static Image hat = DrawingUtility.hatb.getScaledInstance(Configuration.PLAYER_RADIUS * 2,
			(int) (Configuration.PLAYER_RADIUS * 1.8), Image.SCALE_SMOOTH);

	public static final BufferedImage meteo1load = loadImage("res/img/meteo1.png");
	public static BufferedImage meteo1 = resize(meteo1load, (int) (Configuration.TARGET_RADIUS * 1.5),
			(int) (Configuration.TARGET_RADIUS * 1.5));

	public static final BufferedImage meteo2load = loadImage("res/img/meteo2.png");
	public static BufferedImage meteo2 = resize(meteo2load, (int) (Configuration.TARGET_RADIUS * 1.5),
			(int) (Configuration.TARGET_RADIUS * 1.5));

	public static final BufferedImage meteo3load = loadImage("res/img/meteo3.png");
	public static BufferedImage meteo3 = resize(meteo3load, (int) (Configuration.TARGET_RADIUS * 1.5),
			(int) (Configuration.TARGET_RADIUS * 1.5));
	public static final BufferedImage meteo4load = loadImage("res/img/meteo4.png");
	public static BufferedImage meteo4 = resize(meteo4load, (int) (Configuration.TARGET_RADIUS * 1.5),
			(int) (Configuration.TARGET_RADIUS * 1.5));
	public static final BufferedImage meteo5load = loadImage("res/img/meteo5.png");
	public static BufferedImage meteo5 = resize(meteo5load, (int) (Configuration.TARGET_RADIUS * 1.5),
			(int) (Configuration.TARGET_RADIUS * 1.5));

	public static Image dimg = DrawingUtility.gameBG.getScaledInstance(Configuration.screenWidth,
			Configuration.screenHeight, Image.SCALE_SMOOTH);
	public static Image earth = DrawingUtility.earth2.getScaledInstance(Configuration.PLAYER_RADIUS * 2,
			Configuration.PLAYER_RADIUS * 2, Image.SCALE_SMOOTH);
	public static Image fireball = DrawingUtility.fireball2.getScaledInstance(115, 80, Image.SCALE_SMOOTH);
	public static Image myframe = DrawingUtility.myframe2.getScaledInstance(Configuration.screenWidth,
			Configuration.screenHeight, Image.SCALE_SMOOTH);

	public static final Font drawFont = loadFont("res/font/", Configuration.FONT_NAME);

	private static BufferedImage loadImage(String directory) {
		try {
			ClassLoader load = DrawingUtility.class.getClassLoader();
			return ImageIO.read(load.getResource(directory));
		} catch (Exception e) {
			return null;
		}
	}

	public static BufferedImage getClickableImg(BufferedImage imagerow, int state) {
		if (state < 3)
			return imagerow.getSubimage(imagerow.getWidth() * state / 3, 0, imagerow.getWidth() / 3,
					imagerow.getHeight());
		else
			return null;
	}

	private static Font loadFont(String directory, String name) {
		try {
			ClassLoader load = DrawingUtility.class.getClassLoader();
			return Font.createFont(Font.TRUETYPE_FONT, load.getResourceAsStream(directory + name))
					.deriveFont(Configuration.FONT_SIZE);
		} catch (IOException | FontFormatException e) {
			return new Font(Font.SANS_SERIF, 0, (int) Configuration.FONT_SIZE);
		}
	}

	public static void setGameScreen(GameScreen gs) {
		gameScreen = gs;
	}

	public static double getWidthResizeFactor() {
		if (gameScreen == null) {
			return 1;
		} else {
			return gameScreen.getWidth() * 1.0 / GameScreen.screenWidth;
		}
	}

	public static double getHeightResizeFactor() {
		if (gameScreen == null) {
			return 1;
		} else {
			return gameScreen.getHeight() * 1.0 / GameScreen.screenHeight;
		}
	}

	public static void drawCircle(Graphics2D g2, int x, int y, int innerRadius, int outterRadius, Color innerColor,
			Color outterColor) {
		g2.setColor(outterColor);
		g2.fillOval(x - outterRadius, y - outterRadius, outterRadius * 2, outterRadius * 2);
		g2.setColor(innerColor);
		g2.fillOval(x - innerRadius, y - innerRadius, innerRadius * 2, innerRadius * 2);
	}

	public static void drawCircle_2(Graphics2D g2, int x, int y, int stroke) {

	}

	public static void drawTarget(Graphics2D g2, int x, int y) {
		g2.drawImage(DrawingUtility.meteo1, x - (int) (Configuration.TARGET_RADIUS * 1.5) / 2,
				y - (int) (Configuration.TARGET_RADIUS * 1.5) / 2, null);

	}

	public static void drawHit(Graphics2D g) {
		if (Configuration.SHOW_HIT_EFFECT) {
			if (Configuration.HIT_EFFECT_TYPE == 1) {
				g.setComposite(Configuration.transcluentWhite);
				g.setColor(Color.RED);
				g.fillRect(0, 0, Configuration.screenWidth, Configuration.screenHeight);
				g.setComposite(Configuration.opaque);
			} else {
				g.setComposite(Configuration.transcluentWhite);
				g.setColor(Color.RED);
				g.fillOval(Configuration.screenWidth / 2 - Player.RADIUS,
						Configuration.screenHeight / 2 - Player.RADIUS, Configuration.PLAYER_RADIUS * 2,
						Configuration.PLAYER_RADIUS * 2);
				g.setComposite(Configuration.opaque);
			}
		}
	}

	public static void drawMeteo(Graphics2D g, int x, int y, int ran, int count) {
		double rotationRequired = Math.toRadians(count);
		double locationX = Configuration.TARGET_RADIUS * 1.5 / 2;
		double locationY = Configuration.TARGET_RADIUS * 1.5 / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		g.drawImage(op.filter(meteo1, null), x, y, null);

	}

	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}

	public static void drawScore(Graphics2D g) {
		String s = String.format("SCORE : %010d", Player.getInstance().getScore());
		g.setFont(DrawingUtility.drawFont);
		g.setColor(Color.WHITE);
		g.drawString(s, Configuration.screenWidth - g.getFontMetrics().stringWidth(s) - Configuration.SCORE_SCREEN_OFFSET,
				Configuration.screenHeight - Configuration.HEALTH_BAR_THICK - Configuration.SCORE_SCREEN_OFFSET);

	}

	public static void drawHealthBar(Graphics2D g2) {
		g2.setColor(Color.GRAY);
		Rectangle r = new Rectangle(Configuration.HEALTH_BAR_SCREEN_OFFSET,
				Configuration.screenHeight - Configuration.HEALTH_BAR_MAX_HEIGHT - Configuration.HEALTH_BAR_THICK * 2 - Configuration.HEALTH_BAR_SCREEN_OFFSET,
				Configuration.HEALTH_BAR_MAX_WIDTH + Configuration.HEALTH_BAR_THICK * 2,
				Configuration.HEALTH_BAR_MAX_HEIGHT + Configuration.HEALTH_BAR_THICK * 2);
		Paint redtowhite = new GradientPaint(0, 0, Color.DARK_GRAY, Configuration.HEALTH_BAR_MAX_WIDTH / 2, 0,
				Color.gray);
		g2.setPaint(redtowhite);
		g2.fill(r);
		g2.draw(r);
		g2.setColor(Color.BLACK);
		g2.fillRect(Configuration.HEALTH_BAR_SCREEN_OFFSET + Configuration.HEALTH_BAR_THICK,
				Configuration.screenHeight - Configuration.HEALTH_BAR_MAX_HEIGHT - Configuration.HEALTH_BAR_THICK - Configuration.HEALTH_BAR_SCREEN_OFFSET,
				Configuration.HEALTH_BAR_MAX_WIDTH, Configuration.HEALTH_BAR_MAX_HEIGHT);

		r = new Rectangle(Configuration.HEALTH_BAR_SCREEN_OFFSET + Configuration.HEALTH_BAR_THICK,
				Configuration.screenHeight - Configuration.HEALTH_BAR_SCREEN_OFFSET - Configuration.HEALTH_BAR_MAX_HEIGHT - Configuration.HEALTH_BAR_THICK,
				(int) (Player.getInstance().getPercentHitPoint() * Configuration.HEALTH_BAR_MAX_WIDTH / 100.0),
				Configuration.HEALTH_BAR_MAX_HEIGHT);
		Paint redToGreen = new GradientPaint(0, 0, Color.ORANGE, Configuration.HEALTH_BAR_MAX_WIDTH / 2, 0, Color.RED);
		g2.setPaint(redToGreen);
		g2.fill(r);
		g2.setColor(Color.RED);
		if (!Player.getInstance().isDead()) {
			g2.setColor(Color.BLACK);
			g2.setFont(DrawingUtility.drawFont.deriveFont(Configuration.HEALTH_BAR_FONT_SIZE));
			g2.drawString(String.format("%.2f ", Player.getInstance().getPercentHitPoint()) + "%",
					Configuration.HEALTH_BAR_SCREEN_OFFSET + Configuration.HEALTH_BAR_THICK,
					Configuration.screenHeight - Configuration.HEALTH_BAR_THICK - Configuration.HEALTH_BAR_SCREEN_OFFSET);
		} else {
			g2.setColor(Color.RED);
			g2.setFont(DrawingUtility.drawFont.deriveFont(Configuration.HEALTH_BAR_FONT_SIZE));
			g2.drawString(String.format("	YOU ARE DEAD"), Configuration.HEALTH_BAR_SCREEN_OFFSET + Configuration.HEALTH_BAR_THICK,
					Configuration.screenHeight - Configuration.HEALTH_BAR_THICK - Configuration.HEALTH_BAR_SCREEN_OFFSET);
		}
	}

	public static void drawPlayer(Graphics2D g2) {
		if (util.DrawingUtility.earth != null) {
			g2.drawImage(util.DrawingUtility.earth, Configuration.screenWidth / 2 - Configuration.PLAYER_RADIUS,
					Configuration.screenHeight / 2 - Configuration.PLAYER_RADIUS, null);
		}
		if (util.DrawingUtility.thugglasses != null && Configuration.DRAW_GLASS && TargetSpawner.getSpawnMultiplyer()==0) {
			g2.drawImage(DrawingUtility.thugglasses, Configuration.screenWidth / 2 - Configuration.PLAYER_RADIUS,
					Configuration.screenHeight / 2 - Configuration.PLAYER_RADIUS + Configuration.PLAYER_RADIUS / 6,
					null);
		}
		if (util.DrawingUtility.hat != null && Configuration.DRAW_HAT&& TargetSpawner.getSpawnMultiplyer()==0) {
			g2.drawImage(DrawingUtility.hat, Configuration.screenWidth / 2 - (int) (Configuration.PLAYER_RADIUS * 1.2),
					Configuration.screenHeight / 2 - Configuration.PLAYER_RADIUS
							- (int) (Configuration.PLAYER_RADIUS / 1.5),
					null);
		}
	}
}
