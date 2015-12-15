package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

import Interface.IDestroyable;
import Interface.IRenderable;

public class RenderableHolder {
	public ArrayList<IRenderable> getEntities() {
		return entities;
	}
	/*
	 * public void setEntities(ArrayList<IRenderable> entities) { this.entities
	 * = entities; }
	 */

	private static RenderableHolder instance = new RenderableHolder();
	private static ArrayList<IRenderable> entities = new ArrayList<IRenderable>();

	public static RenderableHolder getInstance() {

		return instance;
	}

	public static void reset() {
		instance = new RenderableHolder();
	}

	public boolean candraw;
	public static boolean isDebug = true;

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
	}

	public static void add(IRenderable r) {
		if (entities != null) {
			synchronized (entities) {
				entities.add(r);
			}
		}
	}

	public static void addBack(IRenderable r) {
		if (entities != null) {
			synchronized (entities) {
				entities.add(entities.size(), r);
			}
		}
	}

	public static void addFront(IRenderable r) {
		if (entities != null) {
			synchronized (entities) {
				entities.add(0, r);
			}
		}
	}

	public static void draw(Graphics2D g) {
		if (entities == null)
			return;
		synchronized (entities) {
			for (Iterator<IRenderable> itr = entities.iterator(); itr.hasNext();) {
				IRenderable r = itr.next();
				synchronized (r) {
					if (r instanceof IDestroyable && ((IDestroyable) r).isDestroyed()) {
						itr.remove();
					} else {
						r.draw(g);
					}
				}
			}
		}
		Player.getInstance().draw(g);
		if (!isDebug) {
			g.setColor(Color.RED);
			g.drawString(String.format("Total render object : %d", entities.size()), 0, 10);
		}
	}
}
