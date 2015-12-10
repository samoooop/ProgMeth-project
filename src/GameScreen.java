import javax.swing.JComponent;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

@SuppressWarnings("serial")
public class GameScreen extends JComponent {
	public boolean checkboundary = false;
	public MovingObject now;

	public GameScreen() {
		this.setPreferredSize(new Dimension(640, 480));
		this.setVisible(true);
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
				// TODO Auto-generated method stub
				if (InputUtility.getMouseLeftDown()) {
					InputUtility.setMouseLeftDown(true);
					InputUtility.setMouseLeftTriggered(true);
				}
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				InputUtility.setMouseLeftDown(false);
			}

		});
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setMouseMoved(true);
				InputUtility.setMouseLocation(e.getPoint());

			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setMouseMoved(true);
				InputUtility.setMouseLocation(e.getPoint());
			}

		});

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.yellow);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());// Clear Screen
		requestFocus();
		RenderableHolder.draw(g2d);
		InputUtility.update();
		// System.out.println(RenderableHolder.totalLine());
		// System.out.println(InputUtility.getMouseLocation().toString());
	}
}
