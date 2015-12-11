import java.awt.Graphics2D;

import render.IRenderable;

public class Player implements IRenderable, Hitable {
	
	private static final Player instance = new Player();

	public static Player getInstance() {

		return instance;
	}
	
	private boolean pause = false;

	public void setPause(boolean b) {
		pause = b;
	}

	public boolean isPause() {
		return pause;
	}

	@Override
	public void draw(Graphics2D a) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hit(int x, int y, int r) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

}
