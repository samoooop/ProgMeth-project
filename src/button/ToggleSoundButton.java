 
package button;

import java.awt.Graphics2D;


import util.AudioUtility;
import util.Configuration;
import util.DrawingUtility;


public class ToggleSoundButton extends Clickable {
	public ToggleSoundButton(){
		
		initialize();
		isMuted = true;
	}

	@Override
	public int getZ() {
		return 10000;
	}

	@Override
	public void draw(Graphics2D g) {
		if(AudioUtility.isMuted())
			drawButton(g, DrawingUtility.soundOff);
		else
			drawButton(g, DrawingUtility.soundOn);
	}
	
	@Override
	public void initialize() {
		width = 50;
		height = 50;
		x = Configuration.screenWidth - width -15;
		y = Configuration.screenHeight - 160;
	}
	
	@Override
	public void onClickAction() {
		AudioUtility.setMuted(!AudioUtility.isMuted());
		if(AudioUtility.isMuted())
			AudioUtility.bgm.stop();
		else
			AudioUtility.bgm.loop();
	}

}
