package Game;
import javax.swing.JFrame;

import util.Configuration;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("PROJECT");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameScreen gameScreen = new GameScreen();
		frame.getContentPane().add(gameScreen);
		//frame.add(gameScreen);
		frame.setVisible(true);
		//frame.setResizable(false);
		frame.pack();
		GameLogic gameLogic = new GameLogic();
		gameScreen.requestFocus();
		/*
		 * while (true) { try { Thread.sleep(20); } catch (InterruptedException
		 * e) { } gameScreen.repaint(); gameLogic.logicUpdate(); //
		 * GameLogic.getInstance().logicUpdate(); //
		 * System.out.println("Updated"+InputUtility.getKeyPressed(KeyEvent.
		 * VK_LEFT)+InputUtility.getKeyPressed(KeyEvent.VK_RIGHT)); }
		 */
		Thread drawThread = new Thread() {
			public void run() {
				while (true) {
					gameScreen.repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}
			}

		};
		Thread logicThread = new Thread() {
			public void run() {
				while (!Player.getInstance().isDead()) {
					try {
						Thread.sleep(Configuration.TIME_PER_TICK);
					} catch (InterruptedException e) {
					}
					if(!Player.getInstance().isPause())
					gameLogic.logicUpdate();

				}
			}

		};
		logicThread.start();
		drawThread.start();
	}
}
