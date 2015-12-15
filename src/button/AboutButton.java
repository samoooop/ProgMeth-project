
package button;

import java.awt.Graphics2D;

import util.Configuration;
import util.DrawingUtility;
import util.HighScoreUtility;

public class AboutButton extends Clickable {
	public AboutButton() {

		initialize();
	}

	@Override
	public int getZ() {
		return 10000;
	}

	@Override
	public void draw(Graphics2D g) {

		drawButton(g, DrawingUtility.aboutButton);
		
	}

	@Override
	public void initialize() {
		width = 50;
		height = 50;
		x = Configuration.screenWidth - width - 15;
		y = Configuration.screenHeight - 75;
	}

	@Override
	public void onClickAction() {
		
		
	    HighScoreUtility.displayTop10();
	
	}

}
