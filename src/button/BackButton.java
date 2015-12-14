
package button;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

import Game.GameManager;
import control.ScreenState;
import render.IRenderable;
import util.DrawingUtility;

public class BackButton extends Clickable implements IRenderable {
	public BackButton() {
		initialize();
	}

	@Override
	public int getZ() {
		return 10000;
	}

	@Override
	public void draw(Graphics g) {
		drawButton(g, DrawingUtility.backButton);
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
		GameManager.getInstance().setPause(true);
		if (ScreenState.presentScreen == ScreenState.GAME)
			if (JOptionPane.showConfirmDialog(null, "Are you sure you want to go back?\nGame score will not be saved.",
					"Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				ScreenState.presentScreen = ScreenState.TITLE;
	}

	@Override
	public void draw(Graphics2D a) {
		drawButton(a, DrawingUtility.backButton);

	}
}
