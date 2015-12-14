

package button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

import IRenderable.IRenderable2;
//import control.Game;
//import control.ScreenState;
import ui.*;
import util.Configuration;
import util.DrawingUtility;
import util.InputUtility3;
//import logic.Board;

public class AboutButton extends Clickable  {
	public AboutButton(){
		
		initialize();
	}

	@Override
	public int getZ() {
		return 10000;
	}

	@Override
	public void draw(Graphics g) {
		
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
