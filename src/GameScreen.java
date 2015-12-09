import javax.swing.JComponent;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameScreen extends JComponent {
	public boolean checkboundary = false;
	public MovingObject now;

	public GameScreen() {
		this.setPreferredSize(new Dimension(640, 480));
		this.setVisible(true);
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub

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
				InputUtility.setMouseMoved(e.getPoint());

			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setMouseMoved(e.getPoint());
			}

		});

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.yellow);
		g2d.fillRect(0, 0, 90000, 40000);// Clear the
																// Screen
		requestFocus();
		if (InputUtility.getMouseLeftDown()) {
			// check if the point is inside any object in entities
			int x1 = 0;
			int y1 = 0;

			if (InputUtility.isMouseLeftTriggered() == true) {
				x1 = InputUtility.getMouseLocation().x;
				y1 = InputUtility.getMouseLocation().y;
				InputUtility.setMouseLeftTriggered(false);
			}

			// also dont sure if class named Object is already exist in java.
			for (int i = 0; i < RenderableHolder.getInstance().getEntities().size(); i++) {
				if (RenderableHolder.getInstance().getEntities().get(i) instanceof MovingObject) {
					MovingObject tem = new MovingObject();
					tem = (MovingObject) RenderableHolder.getInstance().getEntities().get(i);
					if (Math.hypot(x1 - tem.x, y1 - tem.y) <= 5) {
						checkboundary = true;
						now = (MovingObject) RenderableHolder.getInstance().getEntities().get(i);
					}
					;

				}
			}
			if (InputUtility.getMouseLeftDown() && checkboundary) {
				RenderableHolder.getInstance().addPointToLine(InputUtility.getMouseLocation(), now);
				System.out.println(InputUtility.getMouseLocation());
			}
		} else {
			RenderableHolder.endLine();
			checkboundary = false;
		}
		RenderableHolder.draw(g2d);
		InputUtility.update();
		// System.out.println(RenderableHolder.totalLine());
		// System.out.println(InputUtility.getMouseLocation().toString());
	}
}
