/**
 * JSpinner: 2110215 PROG METH PROJECT
 * @author Thanawit Prasongpongchai 5631045321
 * @author Phatrasek Jirabovonvisut 5630469621
 */

package button;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import IRenderable.IRenderable2;
//import ui.Clickable;

import util.AudioUtility;
import util.Config;
import util.DrawingUtility;
import util.InputUtility;
//import logic.Board;

public class ToggleSoundButton extends Clickable implements IRenderable2 {
	public ToggleSoundButton(){
		type = Clickable.CIRCLE;
		updatePosition();
		isMuted = true;
	}

	@Override
	public int getZ() {
		return 10000;
	}

	@Override
	public void draw(Graphics g) {
		if(AudioUtility.isMuted())
			drawButton(g, DrawingUtility.soundOn);
		else
			drawButton(g, DrawingUtility.soundOff);
	}
	
	@Override
	public void updatePosition() {
		width = 50;
		height = 50;
		x = Config.screenWidth - width -15;
		y = Config.screenHeight - 160;
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
