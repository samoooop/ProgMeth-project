package Game;

import control.GameWindow;
import control.ScreenState;
import util.Configuration;
import util.TimeUtility;

public class GameManager {
	public static GameManager instance;
	private Thread logicThread;
	private Thread drawingThread;
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
		gs = new GameScreen(frame);

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
					frame.repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}

			}
		};
		logicThread.start();
		drawingThread.start();
		util.AudioUtility.playBG(0);
	}

	public void endGame() {
		this.end = true;
		frame.remove(gs);
		ScreenState.presentScreen = ScreenState.TITLE;
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
		this.pause = b;
	}

	public boolean isPause() {
		return pause;
	}

}
