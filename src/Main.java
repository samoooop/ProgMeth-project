import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("PROJECT");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameScreen gameScreen = new GameScreen();
		frame.getContentPane().add(gameScreen);
		frame.setVisible(true);
		frame.pack();
		GameLogic gameLogic = new GameLogic(gameScreen);
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
						Thread.sleep(20);
					} catch (InterruptedException e) {
					}
				}
			}

		};
		Thread logicThread = new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(20);
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
