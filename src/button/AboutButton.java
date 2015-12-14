
package button;

import java.awt.Graphics2D;

import javax.swing.JOptionPane;
import util.Configuration;
import util.DrawingUtility;

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
		//System.out.println(Configuration.screenWidth);
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
		JOptionPane.showMessageDialog(null, "Top 10 player", "About", JOptionPane.INFORMATION_MESSAGE);
	}

}
