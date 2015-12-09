import java.util.ArrayList;

public class GameLogic {
	// private static GameLogic instance = new GameLogic();
	protected ArrayList<MovingObject> movingObjects;
	protected ArrayList<Target> targets;
	private static final int SPAWN_DELAY = 1;
	private int spawnDelayCounter;
	private GameScreen gs;

	public GameLogic(GameScreen gs) {
		this.gs = gs;
		movingObjects = new ArrayList<MovingObject>();
		targets = new ArrayList<Target>();
		spawnDelayCounter = 0;
	}

	public void logicUpdate() {
		/*
		 * for (int i = 0; i < movingObjects.size(); i++) {
		 * movingObjects.get(i).update(); for (int j = 0; j <
		 * movingObjects.size(); j++) { if
		 * (movingObjects.get(i).collideWith(movingObjects.get(j))) {
		 * movingObjects.get(i).setDestroyed(true); } } if
		 * (movingObjects.get(i).isDestroyed()) { movingObjects.remove(i); i--;
		 * }
		 * 
		 * }
		 */
		for (Target t : targets) {
			t.update();
		}
		spawnDelayCounter++;
		if (spawnDelayCounter >= SPAWN_DELAY) {
			spawnDelayCounter = 0;
			spawnNewTarget();

		}

	}

	public void spawnNewTarget() {
		int x, y;
		int cenX = gs.getWidth() / 2, cenY = gs.getHeight() / 2;
		int ranFactor = (int) (Math.random() * 10000) % 4;
		switch (ranFactor) {
		case 0: // spawn from EAST
			x = 0;
			y = (int) (Math.random() * 10000) % gs.getHeight();
			break;
		case 1: // spawn from WEST
			x = gs.getWidth();
			y = (int) (Math.random() * 10000) % gs.getHeight();
			break;
		case 2: // spawn from NORTH
			x = (int) (Math.random() * 10000) % gs.getWidth();
			y = 0;
			break;
		default: // spawn from SOUTH
			x = (int) (Math.random() * 10000) % gs.getWidth();
			y = gs.getHeight();
			break;
		}
		double vel_x = cenX - x, vel_y = cenY - y;
		vel_x /= gs.getWidth() * 2;
		vel_y /= gs.getHeight() * 2;
		Target t = new Target(x, y, vel_x, vel_y);
		targets.add(t);
		System.out.println("Spawned Target" + String.format(" -> %d %d %f %f (%d)", x, y, vel_x, vel_y, ranFactor));
		RenderableHolder.add(t);
	}
}
