import javax.swing.JComponent;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Catch a fruit");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//GameLogic gameLogic = new GameLogic();
		JComponent gameScreen = new GameScreen();

		
		frame.getContentPane().add(gameScreen);
		frame.setVisible(true);
		frame.pack();
		gameScreen.requestFocus();
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			gameScreen.repaint();
			GameLogic.getInstance().logicUpdate();
			//System.out.println("Updated"+InputUtility.getKeyPressed(KeyEvent.VK_LEFT)+InputUtility.getKeyPressed(KeyEvent.VK_RIGHT));
		}
	}
}
