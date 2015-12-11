import java.util.ArrayList;
import java.util.Iterator;

public class GameLogic {
	// private static GameLogic instance = new GameLogic();
	protected ArrayList<MovingObject> movingObjects;
	protected ArrayList<Target> targets;
	private static final int SPAWN_DELAY = 100;
	private int spawnDelayCounter;
	private GameScreen gs;
	private boolean canSpawnNewTarget = true;
	private Target selected;

	public GameLogic(GameScreen gs) {
		this.gs = gs;
		movingObjects = new ArrayList<MovingObject>();
		targets = new ArrayList<Target>();
		spawnDelayCounter = 0;
		selected = null;
		// init();
	}

	public void init() {
		Target t = new Target(gs.getWidth() / 2, gs.getHeight() / 2, 0, 0, gs);
		targets.add(t);
		RenderableHolder.add(t);

	}

	public void logicUpdate() {
		selectionHandler(); // a function handle mouse Target selection

		for (Iterator<Target> itr = targets.iterator(); itr.hasNext();) {
			Target t = itr.next();
			if (t.isDestroyed()) {
				System.out.println(String.format("Remove(%d,%d) Total : %d %d", t.getX(), t.getY(), targets.size(),
						RenderableHolder.getInstance().getEntities().size()));
				itr.remove();
			} else {
				t.update();
			}
		}
		spawnDelayCounter++;
		if (spawnDelayCounter >= SPAWN_DELAY && canSpawnNewTarget) {
			spawnDelayCounter = 0;
			spawnNewTarget();

		}

	}

	public void spawnNewTarget() {
		Target t = new Target(gs);
		targets.add(t);
		RenderableHolder.add(t);
	}

	public void selectionHandler() {
		if (InputUtility.getMouseLeftDown()) {
			if (selected == null) {
				for (Target t : targets) {
					if (t.isMouseOver()) {
						selected = t;
						t.setSelected(true);
						break;
					}
				}
			}
		} else {
			if (selected != null) {
				selected.setSelected(false);
				selected = null;
			}
		}
	}
}
