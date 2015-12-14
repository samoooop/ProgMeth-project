
package button;

import Game.*;
import render.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import IRenderable.IRenderable2;

//import ui.winpanel.*;
import util.AudioUtility;
import util.DrawingUtility;
import util.InputUtility3;
//import logic.*;

public abstract class Clickable implements IRenderable2, IUpdatable {
	protected int x, y;
	protected int width, height;

	protected boolean isVisible = true;
	protected boolean isMuted = false;

	// public static List<Clickable> buttons = new ArrayList<Clickable>();

	// public static ClockWiseButton cwButton = new ClockWiseButton();
	// public static CounterClockWiseButton ccwButton = new
	// CounterClockWiseButton();
	// public static HelpButton helpButton = new HelpButton();
	/*
	 * static{ buttons.add(new ShuffleButton()); buttons.add(new UndoButton());
	 * buttons.add(cwButton); buttons.add(ccwButton); buttons.add(new
	 * RestartButton()); buttons.add(new NextLevelButton()); buttons.add(new
	 * GoBackButton()); buttons.add(helpButton); buttons.add(new BackButton());
	 * buttons.add(new ToggleSoundButton()); }
	 */
	public Clickable() {
	}

	public boolean isMouseOn() {
		if (this instanceof BackButton) {
			int mx1 = InputUtility.getMouseLocation().x;
			int my1 = InputUtility.getMouseLocation().y;
			int r1 = Math.min(width, height) / 2;
			return (mx1 - (x + r1)) * (mx1 - (x + r1)) + (my1 - (y + r1)) * (my1 - (y + r1)) <= r1 * r1;
		}
		int mx = (int) InputUtility3.getPickedPoint().getX();
		int my = (int) InputUtility3.getPickedPoint().getY();

		int r = Math.min(width, height) / 2;
		return (mx - (x + r)) * (mx - (x + r)) + (my - (y + r)) * (my - (y + r)) <= r * r;
	}

	// ubdate here ahahahahaahahaa
	public void update() {

		if (isMouseOn() && isVisible) {
			mouseOnAction();

			if (this instanceof BackButton) {
				if (InputUtility.isMouseLeftTriggered()) {
					if (!isMuted) {
						AudioUtility.playSound(AudioUtility.clickSound);
					}
					onClickAction();

				}

			}

			if (InputUtility3.isMouseReleased()) {
				if (!isMuted) {
					AudioUtility.playSound(AudioUtility.clickSound);
				}
				onClickAction();
			}
		}
		initialize();
	}

	public void onClickAction() {

	}

	public void mouseOnAction() {

	}

	public abstract int getZ();

	public abstract void draw(Graphics g);

	public abstract void initialize();

	protected void drawButton(Graphics g, BufferedImage buttonSprite) {
		Graphics2D g2 = (Graphics2D) g;
		if (!isMouseOn()) {
			if (!(this instanceof PlayButton)) {
				g2.drawImage(DrawingUtility.fireball, x - 45, y - 15, null);
			}
			g2.drawImage(DrawingUtility.getClickableImg(buttonSprite, DrawingUtility.STATE_NORMAL), null, x, y);
		} else if (InputUtility3.isMouseDown()) {
			if (!(this instanceof PlayButton)) {
				g2.drawImage(DrawingUtility.fireball, x - 45, y - 15, null);
			}
			g2.drawImage(DrawingUtility.getClickableImg(buttonSprite, DrawingUtility.STATE_CLICK), null, x, y);
		} else {
			if (!(this instanceof PlayButton)) {
				g2.drawImage(DrawingUtility.fireball, x - 45, y - 15, null);
			}
			g2.drawImage(DrawingUtility.getClickableImg(buttonSprite, DrawingUtility.STATE_HOVER), null, x, y);
		}
	}

	protected void mute() {
		isMuted = true;
	}
}
