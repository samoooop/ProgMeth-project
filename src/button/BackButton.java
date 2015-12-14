
package button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

import IRenderable.IRenderable2;
import control.ScreenState;
import util.DrawingUtility;
import util.InputUtility;


public class BackButton extends Clickable implements IRenderable2 {
	public BackButton(){
		
		initialize();
	}

	@Override
	public int getZ() {
		return 10000;
	}

	@Override
	public void draw(Graphics g) {
		drawButton(g, DrawingUtility.backButton);
	}

	@Override
	public void initialize(){
		x = 5;
		y =  10;
		width = 50;
		height = 50;
	}
	
	@Override
	public void onClickAction() {
//		JOptionPane.showMessageDialog(null, "BACK");
		
		if(ScreenState.presentScreen == ScreenState.GAME)
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to go back?\nGame score will not be saved.", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				ScreenState.presentScreen = ScreenState.TITLE;
		//WinPanel.setVisible(false);
		//HelpPanel.setVisible(false);
	}
}
