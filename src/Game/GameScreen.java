package Game;
import javax.swing.JPanel;

import util.Configuration;
import util.DrawingUtility;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

@SuppressWarnings("serial")
public class GameScreen extends JPanel{
	public boolean checkboundary = false;
	public MovingObject now;
	public static int screenWidth = Configuration.screenWidth;
	public static int screenHeight = Configuration.screenHeight;
	public GameScreen() {
		//this.createBufferStrategy(2);
		this.requestFocus();
		this.setDoubleBuffered(true);
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setVisible(true);
		DrawingUtility.setGameScreen(this);
		this.addKeyListener(new KeyListener(){

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
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(util.DrawingUtility.dimg, 0, 0, null);
		//g2d.setColor(DrawingUtility.BACKGROUND_COLOR);
		//g2d.fillRect(0, 0, this.getWidth(), this.getHeight());// Clear Screen
		requestFocus();
		RenderableHolder.draw(g2d);
		InputUtility.update();
		// System.out.println(RenderableHolder.totalLine());
		// System.out.println(InputUtility.getMouseLocation().toString());
	}
	
}
