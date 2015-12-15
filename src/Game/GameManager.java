package Game;

import control.GameWindow;
import control.ScreenState;
import util.Configuration;
import util.HighScoreUtility;
import util.InputUtility_Game;
import util.TimeUtility;

public class GameManager {
	public static Object inputInterrupter = new Object();
	public static GameManager instance;
	private Thread logicThread;
	private Thread drawingThread;
	private Thread inputThread;
	private GameWindow frame;
	private GameScreen gs;
	private boolean end;
	private boolean pause;

	public GameManager(GameWindow frame) {
		this.frame = frame;
		this.end = false;
		this.pause = false;
		GameManager.instance = this;
	}

	public static GameManager getInstance() {
		return instance;
	}

	public void newGame() {
		this.end = false;
		this.pause = false;
		gs = new GameScreen(frame);
		resetAll();
		setConfigForGame();
		GameLogic gameLogic = new GameLogic();
		logicThread = new Thread() {
			public void run() {
				while (!end) {
					if (!pause) {
						gameLogic.logicUpdate();
						TimeUtility.inceaseTick();
					}
					try {
						Thread.sleep(Configuration.TIME_PER_TICK);
					} catch (InterruptedException e) {
					}

				}

			}

		};
		drawingThread = new Thread() {
			public void run() {
				while (!end) {
					if (!pause) {
						frame.repaint();
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}

			}
		};
		inputThread = new Thread() {
			public void run() {
				while (!end) {
					try {
						synchronized (inputInterrupter) {
							inputInterrupter.wait();
						}
					} catch (InterruptedException e) {
					}
					util.InputUtility_Game.update();
				}
			}
		};
		logicThread.start();
		drawingThread.start();
		inputThread.start();
		util.AudioUtility.playBG(0);
	}

	public void endGame() {

		this.end = true;
		frame.remove(gs);
		HighScoreUtility.recordHighScore((int) Player.getInstance().getScore());
		ScreenState.presentScreen = ScreenState.REFRESH_TITLE;
		util.AudioUtility.pauseBG();
		synchronized (this) {
			this.notifyAll();
		}
	}

	public void setPause(boolean b) {
		if (!b) {
			util.AudioUtility.playBG(util.TimeUtility.getEscalatedTime());
		} else {
			util.AudioUtility.pauseBG();
		}
		InputUtility_Game.update();
		this.pause = b;
	}

	public boolean isPause() {
		return pause;
	}

	public static void resetAll() {
		Player.reset();
		RenderableHolder.reset();
		TimeUtility.reset();
		TargetSpawner.reset();
	}

	public static void setConfigForGame() {
		Configuration.DRAW_HEALTH_BAR = true;
		Configuration.DRAW_SCORE = true;
		Configuration.SHOW_HIT_EFFECT = true;
		Configuration.REGEN_SPEED = Configuration.REGEN_SPEED_DEFAULT;
		Configuration.SPAWN_DELAY = Configuration.SPAWN_DELAY_GAME;
		Configuration.TARGET_RADIUS = Configuration.TARGET_RADIUS_GAME;
		Configuration.TARGET_HIT_SOUND_EFFECT = true;
	}

	public static void setConfigForTitle() {
		Configuration.DRAW_HEALTH_BAR = false;
		Configuration.DRAW_SCORE = false;
		Configuration.SHOW_HIT_EFFECT = false;
		Configuration.REGEN_SPEED = 1000;
		Configuration.SPAWN_DELAY = Configuration.SPAWN_DELAY_TITLE;
		Configuration.TARGET_RADIUS = Configuration.TARGET_RADIUS_TITLE;
		Configuration.TARGET_HIT_SOUND_EFFECT = false;

	}
}
