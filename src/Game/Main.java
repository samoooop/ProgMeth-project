package Game;

import javax.swing.JDialog;
import javax.swing.JFrame;

import util.Configuration;
import util.TimeUtility;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("PROJECT");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameScreen gameScreen = new GameScreen();
		frame.getContentPane().add(gameScreen);
		frame.setVisible(true);
		frame.pack();
		GameLogic gameLogic = new GameLogic();
		Thread logicThread = new Thread() {
			public void run() {
				while (!Player.getInstance().isDead()) {
					if (!Player.getInstance().isPause()) {
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
		Thread drawThread = new Thread() {
			public void run() {
				while (true) {
					gameScreen.repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
					//System.out.println(logicThread.isAlive());
				}
				
			}

		};
		logicThread.start();
		drawThread.start();
	}
}
