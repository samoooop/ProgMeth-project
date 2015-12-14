

package button;

import java.awt.Graphics2D;

//import control.Game;
//import control.ScreenState;
//import ui.Clickable;
import control.ScreenState;
import util.AudioUtility;
import util.Configuration;
import util.DrawingUtility;
//import logic.Board;

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
		//System.out.println(Configuration.screenWidth);
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
//		ScreenState.presentScreen = ScreenState.LEVEL_SELECT;
	ScreenState.presentScreen = ScreenState.GAME;
	AudioUtility.bgm.stop();
	}
}
