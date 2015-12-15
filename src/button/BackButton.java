
package button;

import java.awt.Graphics2D;

import javax.swing.JOptionPane;

import Interface.IRenderable;
import control.ScreenState;
import game.GameManager;
import util.DrawingUtility;
import util.InputUtility_Game;

public class BackButton extends Clickable implements IRenderable {
	public BackButton() {
		initialize();
	}

	@Override
	public int getZ() {
		return 10000;
	}

	@Override
	public void initialize() {
		x = 10;
		y = 10;
		width = 50;
		height = 50;
	}

	@Override
	public void onClickAction() {
		InputUtility_Game.setMouseLeftDown(false);
		GameManager.getInstance().setPause(true);
		if (ScreenState.presentScreen == ScreenState.GAME)
			if (JOptionPane.showConfirmDialog(null, "Are you sure you want to go back?", "Confirm",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				GameManager.getInstance().endGame();
			} else {
				GameManager.getInstance().setPause(false);
			}
	}

	@Override
	public void draw(Graphics2D a) {
		drawButton(a, DrawingUtility.backButton);

	}
}
