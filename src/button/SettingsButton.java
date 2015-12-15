
package button;

import java.awt.Graphics2D;
import render.SettingFrame;
import util.Configuration;
import util.DrawingUtility;

public class SettingsButton extends Clickable {
	public SettingsButton() {

		initialize();
	}

	@Override
	public int getZ() {
		return 10000;
	}

	@Override
	public void draw(Graphics2D g) {
		drawButton(g, DrawingUtility.settingsButtonImg);
	}

	@Override
	public void initialize() {
		width = 50; // 50 naja
		height = 50;
		x = 25;
		y = Configuration.screenHeight - width - 25;
	}

	@Override
	public void onClickAction() {
		new SettingFrame();
	}

}
