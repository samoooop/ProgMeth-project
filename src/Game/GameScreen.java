package Game;

import javax.swing.JPanel;

import util.Configuration;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

@SuppressWarnings("serial")
public class GameScreen extends JPanel {
	public boolean checkboundary = false;
	public MovingObject now;
	public static int screenWidth = Configuration.screenWidth;
	public static int screenHeight = Configuration.screenHeight;

	public GameScreen() {
		this.requestFocus();
		this.setDoubleBuffered(true);
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setVisible(true);
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				System.out.println("HELOOOOO " + arg0.getKeyCode() + " " + KeyEvent.VK_ENTER);
				if(arg0.getKeyCode() == 0){
					System.out.println("HELOOOOO");
					Player.getInstance().setPause(!Player.getInstance().isPause());
				}
				if (arg0.getKeyChar() == KeyEvent.VK_SPACE) {
					System.out.println("using skill");
					Player.getInstance().useSkill = true;
				}

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
				InputUtility.setMouseLeftDown(true);
				InputUtility.setMouseLeftTriggered(true);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				InputUtility.setMouseLeftDown(false);
			}

		});
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				InputUtility.setMouseMoved(true);
				InputUtility.setMouseLocation(e.getPoint());

			}

			@Override
			public void mouseMoved(MouseEvent e) {
				InputUtility.setMouseMoved(true);
				InputUtility.setMouseLocation(e.getPoint());
			}

		});

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		if (util.DrawingUtility.dimg != null) {
			g2d.drawImage(util.DrawingUtility.dimg, 0, 0, null);
		} else {
			g2d.setColor(util.DrawingUtility.BACKGROUND_COLOR);
			g2d.fillRect(0, 0, this.getWidth(), this.getHeight());// Clear
																	// Screen
		}
		if (Configuration.ENABLE_ANTIALLIASING) {
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		requestFocus();
		RenderableHolder.draw(g2d);
		InputUtility.update();
	}

}
