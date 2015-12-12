/**
 * JSpinner: 2110215 PROG METH PROJECT
 * @author Thanawit Prasongpongchai 5631045321
 * @author Phatrasek Jirabovonvisut 5630469621
 */

package button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

import IRenderable.IRenderable2;
//import control.Game;
//import control.ScreenState;
//import ui.Clickable;

import util.Config;
import util.DrawingUtility;
import util.InputUtility;
//import logic.Board;

public class PlayButton extends Clickable implements IRenderable2 {
	public PlayButton(){
		type = Clickable.CIRCLE;
		width = 100;
		height = 100;
		x = (Config.screenWidth - width) / 2;
		y = (Config.screenHeight) / 2;
	}

	@Override
	public int getZ() {
		return 10000;
	}

	@Override
	public void draw(Graphics g) {
		drawButton(g, DrawingUtility.playButtonImg);
	}

	@Override
	public void updatePosition() {	
	}

	@Override
	public void onClickAction() {
//		ScreenState.presentScreen = ScreenState.LEVEL_SELECT;
//		ScreenState.presentScreen = ScreenState.GAME;
	}
}
