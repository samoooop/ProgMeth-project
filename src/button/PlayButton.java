

package button;

import java.awt.Graphics2D;

import control.ScreenState;
import util.AudioUtility;
import util.Configuration;
import util.DrawingUtility;


public class PlayButton extends Clickable {
	public PlayButton(){
		
		initialize();
	}
	@Override
	public int getZ() {
		return 10000;
	}

	@Override
	public void draw(Graphics2D g) {
		drawButton(g, DrawingUtility.playButtonImg);
		
	}

	@Override
	public void initialize() {	
		width = 100;
		height = 100;
		x = (Configuration.screenWidth/2)-width/2;
		
		y = (Configuration.screenHeight) / 2+(int)((Configuration.screenHeight)*0.25);
	
	
	}

	@Override
	public void onClickAction() {
	ScreenState.presentScreen = ScreenState.GAME;
	AudioUtility.bgm.stop();
	}
}
