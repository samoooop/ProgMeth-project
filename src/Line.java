import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import render.IRenderable;

public class Line implements IRenderable {
	private ArrayList<Point> pointList;

	public ArrayList<Point> getPointList() {
		return pointList;
	}

	public Line() {
		pointList = new ArrayList<Point>();
	}

	public void addPoint(Point c) {
		pointList.add(c);
	}

	public Point getIndex(int i) {
		return pointList.get(i);
	}
	
	public int getSize(){
		return pointList.size();
	}
	
	public void removeIndex(int i){
		pointList.remove(i);
	}
	public void draw(Graphics2D g) {
		for (int i = 1; i < pointList.size(); i++) {
			// i = 1 : Skip first point
			Point p1, p2;
			p1 = pointList.get(i - 1);
			p2 = pointList.get(i);
			g.setColor(Color.WHITE);
			g.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
		}
	}
}
