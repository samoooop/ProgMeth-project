package game;

import javax.swing.JPanel;

import control.GameWindow;
import control.ScreenState;
import util.Configuration;
import util.InputUtility_Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

@SuppressWarnings("serial")
public class GameScreen extends JPanel {
	public GameScreen(GameWindow window) {
		super();
		ScreenState.presentScreen = ScreenState.GAME;
		window.addPanel(this);
		this.setPreferredSize(new Dimension(Configuration.screenWidth, Configuration.screenHeight));
		this.requestFocus();
		this.setFocusable(true);
		this.setDoubleBuffered(true);
		this.setVisible(true);
		this.setDoubleBuffered(true);
		window.pack();
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				synchronized (GameManager.inputInterrupter) {
					GameManager.inputInterrupter.notifyAll();
				}
				if (arg0.getKeyChar() == KeyEvent.VK_ENTER) {
					game.GameManager.getInstance().setPause(!game.GameManager.getInstance().isPause());
				}
				if (arg0.getKeyChar() == KeyEvent.VK_SPACE) {
					Player.getInstance().useSkill();
				}
			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

		});
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				if (arg0.getButton() == MouseEvent.BUTTON1) {
					InputUtility_Game.setMouseLeftDown(true);
					InputUtility_Game.setMouseLeftTriggered(true);
				}
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (arg0.getButton() == MouseEvent.BUTTON1) {
					InputUtility_Game.setMouseLeftDown(false);
				}
			}

		});
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				InputUtility_Game.setMouseMoved(true);
				InputUtility_Game.setMouseLocation(e.getPoint());

			}

			@Override
			public void mouseMoved(MouseEvent e) {
				InputUtility_Game.setMouseMoved(true);
				InputUtility_Game.setMouseLocation(e.getPoint());
			}

		});

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		if (util.DrawingUtility.dim != null) {
			g2d.drawImage(util.DrawingUtility.dim, 0, 0, null);
		} 
		if (Configuration.ENABLE_ANTIALLIASING) {
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		requestFocus();
		RenderableHolder.draw(g2d);

	}

}
