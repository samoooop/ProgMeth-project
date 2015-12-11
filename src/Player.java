import java.awt.Graphics2D;

import render.IRenderable;

public class Player implements IRenderable,Hitable{

	@Override
	public void draw(Graphics2D a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hit(int x,int y,int r) {
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
