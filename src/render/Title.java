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
import util.Configuration;
import util.DrawingUtility;
import util.InputUtility3;

public class Title extends JPanel{
	private List<IRenderable2> renderList = new ArrayList<IRenderable2>();
	private List<IUpdatable> updateList = new ArrayList<IUpdatable>();
	public Image dimg =  DrawingUtility.gameBG.getScaledInstance(Configuration.screenWidth, Configuration.screenHeight,
	        Image.SCALE_SMOOTH);
	public Image earth =  DrawingUtility.earth2.getScaledInstance(Configuration.PLAYER_RADIUS*2, Configuration.PLAYER_RADIUS*2,
	        Image.SCALE_SMOOTH);
	
	public static GameWindow wind;
	
	
	public Title(GameWindow window){
          super();
		this.wind = window;
		ScreenState.presentScreen = ScreenState.TITLE;
		AudioUtility.bgm.loop();
		window.addPanel(this);
		window.setFrame();
		setPreferredSize(new Dimension(Configuration.screenWidth, Configuration.screenHeight));
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
			if(InputUtility3.getKeyTriggered(KeyEvent.VK_SPACE)){
				AudioUtility.playSound(AudioUtility.clickSound);
				ScreenState.presentScreen = ScreenState.GAME;
			}
			InputUtility3.postUpdate();
		}
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g.drawImage(dimg,0,0,null);
		//g.drawImage(DrawingUtility.myframe,0,0,null);
		g.drawImage(earth,Configuration.screenWidth/2-150,Configuration.screenHeight/2-150,null);
		//g2.clearRect(0,0,Config.screenWidth,Config.screenHeight);
		
		g2.setColor(new Color(192, 192, 192));
		g2.fillRect(0, 0, Configuration.screenWidth, 27);
		g2.fillRect(0, Configuration.screenHeight-27, Configuration.screenWidth, 27);
		g2.setColor(new Color(160, 160,160));
		g2.fillRect(0, 27, Configuration.screenWidth, 3);
		g2.fillRect(0, Configuration.screenHeight-30, Configuration.screenWidth, 3);
		g2.setColor(new Color(128, 128,128));
		g2.fillRect(0, 30, Configuration.screenWidth, 3);
		g2.fillRect(0, Configuration.screenHeight-33, Configuration.screenWidth, 3);
		g2.setColor(new Color(96, 96,96));
		g2.fillRect(0, 33, Configuration.screenWidth, 3);
		g2.fillRect(0, Configuration.screenHeight-36, Configuration.screenWidth, 3);
		g2.setColor(new Color(64, 64,64));
		g2.fillRect(0, 36, Configuration.screenWidth, 3);
		g2.fillRect(0, Configuration.screenHeight-39, Configuration.screenWidth, 3);
		g2.setColor(new Color(32, 32,32));
		g2.fillRect(0, 39, Configuration.screenWidth, 3);
		
		g2.fillRect(0, Configuration.screenHeight-42, Configuration.screenWidth, 3);
		g2.setColor(new Color(0, 0,0));
		g2.fillRect(0, 42, Configuration.screenWidth, 3);
		g2.fillRect(0, Configuration.screenHeight-45, Configuration.screenWidth, 3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		for(int i = 0; i < renderList.size(); i++){
			renderList.get(i).draw(g);
		}
	
		    g.drawImage(DrawingUtility.cloud1, (int) (Configuration.screenWidth/2-Configuration.PLAYER_RADIUS * 3.2), (int) (Configuration.screenHeight/2-Configuration.screenHeight/2.8), null);  
			
			g.drawImage(DrawingUtility.cloud4, (int) (Configuration.screenWidth/2+Configuration.PLAYER_RADIUS *0.0), (int) (Configuration.screenHeight/2-Configuration.screenHeight/2.9), null);
			g.drawImage(DrawingUtility.cloud3, (int) (Configuration.screenWidth/2+Configuration.PLAYER_RADIUS *0.8), (int) (Configuration.screenHeight/2-Configuration.screenHeight/2.8), null); 
			
			
			g.drawImage(DrawingUtility.cloud2, (int) (Configuration.screenWidth/2-Configuration.PLAYER_RADIUS * 2.0), (int) (Configuration.screenHeight/2-Configuration.screenHeight/2.8), null); 
			
			
			
			g.drawImage(DrawingUtility.logo,(int) (Configuration.screenWidth/2-Configuration.PLAYER_RADIUS * 1.5/2),
					(int) (Configuration.screenHeight/2-Configuration.screenHeight/2.3),null);
		
			g.drawImage(DrawingUtility.logoText,(int) (Configuration.screenWidth/2-Configuration.PLAYER_RADIUS * 3/2),
					(int) (Configuration.screenHeight/2-Configuration.screenHeight/3.6),null);
		
	
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
