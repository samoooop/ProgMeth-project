package render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import IRenderable.IRenderable2;
import button.AboutButton;
import button.PlayButton;
import button.SettingsButton;
import button.ToggleSoundButton;
import control.GameWindow;
import control.ScreenState;
import util.AudioUtility;
import util.Config;
import util.DrawingUtility;
import util.InputUtility;

public class Title extends JPanel{
	private List<IRenderable2> renderList = new ArrayList<IRenderable2>();
	private List<IUpdatable> updateList = new ArrayList<IUpdatable>();
	public Image dimg =  DrawingUtility.gameBG.getScaledInstance(Config.screenWidth, Config.screenHeight,
	        Image.SCALE_SMOOTH);
	public Image earth =  DrawingUtility.earth2.getScaledInstance(400, 400,
	        Image.SCALE_SMOOTH);
	public Title(GameWindow window){
          super();
		
		ScreenState.presentScreen = ScreenState.TITLE;
		
		window.addPanel(this);
		window.setFrame();
		setPreferredSize(new Dimension(Config.screenWidth, Config.screenHeight));
		window.pack();
		
		addBoth(new PlayButton());
		
		addBoth(new SettingsButton());
		addBoth(new AboutButton());
		addBoth(new ToggleSoundButton());
       
       
        while(ScreenState.presentScreen == ScreenState.TITLE){
			
			try{
				
				Thread.sleep(20);
			} catch(InterruptedException e) {
			}
			
			repaint();
			update();
			
			//update
			if(InputUtility.getKeyTriggered(KeyEvent.VK_SPACE)){
				AudioUtility.playSound(AudioUtility.clickSound);
				ScreenState.presentScreen = ScreenState.GAME;
			}
			InputUtility.postUpdate();
		}
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g.drawImage(dimg,0,0,null);
		g.drawImage(earth,Config.screenWidth/2-150,Config.screenHeight/2-150,null);
		//g2.clearRect(0,0,Config.screenWidth,Config.screenHeight);
		g2.setColor(new Color(192, 192, 192));
		g2.fillRect(0, 0, Config.screenWidth, 27);
		g2.fillRect(0, Config.screenHeight-27, Config.screenWidth, 27);
		g2.setColor(new Color(160, 160,160));
		g2.fillRect(0, 27, Config.screenWidth, 3);
		g2.fillRect(0, Config.screenHeight-30, Config.screenWidth, 3);
		g2.setColor(new Color(128, 128,128));
		g2.fillRect(0, 30, Config.screenWidth, 3);
		g2.fillRect(0, Config.screenHeight-33, Config.screenWidth, 3);
		g2.setColor(new Color(96, 96,96));
		g2.fillRect(0, 33, Config.screenWidth, 3);
		g2.fillRect(0, Config.screenHeight-36, Config.screenWidth, 3);
		g2.setColor(new Color(64, 64,64));
		g2.fillRect(0, 36, Config.screenWidth, 3);
		g2.fillRect(0, Config.screenHeight-39, Config.screenWidth, 3);
		g2.setColor(new Color(32, 32,32));
		g2.fillRect(0, 39, Config.screenWidth, 3);
		g2.fillRect(0, Config.screenHeight-42, Config.screenWidth, 3);
		g2.setColor(new Color(0, 0,0));
		g2.fillRect(0, 42, Config.screenWidth, 3);
		g2.fillRect(0, Config.screenHeight-45, Config.screenWidth, 3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		for(int i = 0; i < renderList.size(); i++){
			renderList.get(i).draw(g);
		}
	}
	
	public void update(){
		for(int i = 0; i < updateList.size(); i++){
			updateList.get(i).update();
		}
	}
	
	
	private void addBoth(IRenderable2 a){
		if(a instanceof IUpdatable){
			renderList.add(a);
			updateList.add((IUpdatable)a);
		}
	}
}
