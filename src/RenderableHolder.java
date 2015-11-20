import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import render.IRenderable;

public class RenderableHolder {
	public ArrayList<IRenderable> getEntities() {
		return entities;
	}
	public void setEntities(ArrayList<IRenderable> entities) {
		this.entities = entities;
	}
	private static final RenderableHolder instance = new RenderableHolder();
	private static ArrayList<IRenderable> entities;
public static RenderableHolder getInstance(){
		
		return instance;
	}
	private static Line currentLine ;
	public boolean candraw;
	public RenderableHolder(){
		entities = new ArrayList<IRenderable>();
		currentLine = null ;
	}
	public   void addPointToLine(Point p,MovingObject a){
		
		if(currentLine == null){
			currentLine = new Line();
			a.setObjectline(currentLine);
			entities.add(currentLine);
		}
		currentLine.addPoint(p);
	}
	public static void endLine(){
		currentLine = null;
	}
	
	public static void draw(Graphics2D g){
		if(entities == null) return;
		for( IRenderable l : entities ){
			l.draw(g);
		}
	}
}
