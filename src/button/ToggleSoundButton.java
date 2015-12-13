 
package button;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import IRenderable.IRenderable2;
//import ui.Clickable;

import util.AudioUtility;
import util.Configuration;
import util.DrawingUtility;
import util.InputUtility;


public class ToggleSoundButton extends Clickable implements IRenderable2 {
	public ToggleSoundButton(){
		
		initialize();
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
