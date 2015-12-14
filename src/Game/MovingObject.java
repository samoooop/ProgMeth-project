package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import render.IRenderable;

public class MovingObject implements IRenderable {
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private boolean isDestroyed = false;
	protected int x;
	protected int y;
	protected int i;
	protected int radius = 40;
	private Line objectline;
	private Point startPoint;
	private Point endPoint;
	private double firstangle;
	public int startside;
	private static final int speed = 1;

	public MovingObject() {
		firstangle = RandomUtility.random(45, 135);
		objectline = new Line();
		startside = RandomUtility.random(1, 4);
		startPoint = randomStartPoint(startside);
		endPoint = randomEndPoint(startside);
		firstangle = getAngle(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		Point temp = new Point();
		temp.x = startPoint.x;
		temp.y = startPoint.y;
		objectline.addPoint(temp);
		System.out.println(firstangle);
		for (int i = 1; i <= 1500; i++) {
			temp = new Point();
			
			objectline.addPoint(temp);
		}
		this.x = startPoint.x;
		this.y = startPoint.y;

	}

	public void update() {
		if (this.x > 1202 || this.x < -2 || this.y > 902 || this.y < -2) {
			this.isDestroyed = true;
		}
		if (!this.isDestroyed) {
			if (this.objectline.getPointList().get(i) == null) {
				this.isDestroyed = true;
			} // for exception out of bound
			this.x = (this.objectline.getPointList().get(i)).x;
			this.y = (this.objectline.getPointList().get(i)).y;
			i++;
		}
	}

	public double getAngle(int x1, int y1, int x2, int y2) {
		double angle = (double) Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));

		if (angle < 0) {
			angle += 360;
		}

		return angle;
	}

	public Point randomStartPoint(int startside) {
		Point a = new Point();
		if (startside == 1) {
			a.x = RandomUtility.random(200, 1000);
			a.y = 0;
		} else if (startside == 2) {
			a.x = 0;
			a.y = RandomUtility.random(200, 700);

		} else if (startside == 3) {
			a.x = RandomUtility.random(200, 1000);
			a.y = 900;

		} else if (startside == 4) {
			a.x = 1200;
			a.y = RandomUtility.random(200, 700);

		}

		return a;

	}

	public Point randomEndPoint(int startside) {
		Point end = new Point();
		int rand = RandomUtility.random(1, 5);
		if (startside == 1) {
			if (rand == 1) {
				end.x = 0;
				end.y = 450;
			} else if (rand == 2) {
				end.x = 0;
				end.y = 900;
			} else if (rand == 3) {
				end.x = 600;
				end.y = 900;
			} else if (rand == 4) {
				end.x = 1200;
				end.y = 900;
			} else if (rand == 5) {
				end.x = 1200;
				end.y = 450;
			}

		} else if (startside == 2) {
			if (rand == 1) {
				end.x = 600;
				end.y = 0;
			} else if (rand == 2) {
				end.x = 1200;
				end.y = 0;
			} else if (rand == 3) {
				end.x = 1200;
				end.y = 450;
			} else if (rand == 4) {
				end.x = 1200;
				end.y = 900;
			} else if (rand == 5) {
				end.x = 600;
				end.y = 900;
			}

		} else if (startside == 3) {
			if (rand == 1) {
				end.x = 0;
				end.y = 450;
			} else if (rand == 2) {
				end.x = 0;
				end.y = 0;
			} else if (rand == 3) {
				end.x = 600;
				end.y = 0;
			} else if (rand == 4) {
				end.x = 1200;
				end.y = 0;
			} else if (rand == 5) {
				end.x = 1200;
				end.y = 450;
			}

		} else if (startside == 4) {
			if (rand == 1) {
				end.x = 600;
				end.y = 900;
			} else if (rand == 2) {
				end.x = 0;
				end.y = 900;
			} else if (rand == 3) {
				end.x = 0;
				end.y = 450;
			} else if (rand == 4) {
				end.x = 0;
				end.y = 0;
			} else if (rand == 5) {
				end.x = 600;
				end.y = 0;
			}

		}

		return end;
	}

	public void setDestroyed(boolean a) {
		this.isDestroyed = a;
	}

	public boolean isDestroyed() {
		return this.isDestroyed;
	}

	public Line getObjectline() {
		return objectline;
	}

	public void setObjectline(Line objectline) {
		if (objectline != null) {
			this.i = 1;
			this.objectline = objectline;
		} else
			return;
	}

	public boolean collideWith(MovingObject a) {

		return Math.hypot(this.x - a.x, this.y - a.y) <= this.radius + a.radius;

	}

	@Override
	public void draw(Graphics2D a) {
		a.setColor(Color.blue);
		a.fillOval(x - radius, y - radius, radius * 2, radius * 2);

	}

}
