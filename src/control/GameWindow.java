
package control;

import render.*;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Game.GameManager;
import Game.GameScreen;
import util.Configuration;
import util.InputUtility3;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

	private Title gameTitle;
	private GameScreen game = null;
	Thread logicThread;
	Thread drawThread;
	GameManager gm = new GameManager(this);

	public GameWindow() {
		super("myProject");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
		}
		this.setLocationByPlatform(true);
		Container pane = this.getContentPane();

		if (ScreenState.presentScreen != ScreenState.GAME) {
			addListener(pane);
		}

		setFrame();

		setResizable(false);
		ScreenState.presentScreen = ScreenState.TITLE;

		while (true) {
			if (ScreenState.presentScreen == ScreenState.REFRESH_TITLE) {
				ScreenState.presentScreen = ScreenState.TITLE;
			}

			else if (ScreenState.presentScreen == ScreenState.TITLE) {
				gameTitle = new Title(this);
				this.remove(gameTitle);
			} else if (ScreenState.presentScreen == ScreenState.GAME && game == null) {
				this.remove(gameTitle);
				gm.newGame();
				try {
					synchronized (gm) {
						gm.wait();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.validate();
		}
	}

	public void addPanel(JPanel jp) {
		this.getContentPane().add(jp);
	}
 public void setSizeImidiate(){
	 setSize(Configuration.screenWidth , Configuration.screenHeight +24);
	 validate();
 }
	
	
	public void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Configuration.screenWidth, Configuration.screenHeight +24);
		setVisible(true);
		setResizable(false);
	}

	public void addListener(Container pane) {
		pane.setFocusable(true);
		pane.requestFocus();
		///////////////// Mouse/////////////////
		pane.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility3.setPicking(true);
				InputUtility3.setMouseDown(true);
				// InputUtility.setPickedPoint(e.getX(), e.getY());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility3.setPicking(false);
				InputUtility3.setMouseDown(false);
				InputUtility3.setMouseReleased(true);
				// InputUtility.setPickedPoint(InputUtility.NULL_POINT,
				// InputUtility.NULL_POINT);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});
		if (ScreenState.presentScreen != ScreenState.GAME) {
			pane.addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseMoved(MouseEvent e) {
					InputUtility3.setPickedPoint(e.getX(), e.getY());
				}

				@Override
				public void mouseDragged(MouseEvent e) {
					InputUtility3.setPickedPoint(e.getX(), e.getY());
				}
			});
		}

		/////////////////////// key///////////////////////////
		if (ScreenState.presentScreen != ScreenState.GAME) {
			pane.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent arg0) {
				}

				@Override
				public void keyReleased(KeyEvent e) {
					InputUtility3.setKeyPressed(e.getKeyCode(), false);
				}

				@Override
				public void keyPressed(KeyEvent e) {
					InputUtility3.setKeyTriggered(e.getKeyCode(), true);
					InputUtility3.setKeyPressed(e.getKeyCode(), true);
				}
			});
		}
	}

}
