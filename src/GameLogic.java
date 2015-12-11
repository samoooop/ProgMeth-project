import java.util.ArrayList;
import java.util.Iterator;

public class GameLogic {
	// private static GameLogic instance = new GameLogic();
	protected ArrayList<MovingObject> movingObjects;
	protected ArrayList<Target> targets;
	private static final int SPAWN_DELAY = 10;
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
		init();
	}

	public void init() {
		

	}

	public void logicUpdate() {
		selectionHandler(); // a function handle mouse Target selection
		checkHit();
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
			else if(selected.isDestroyed()){
				selected = null;
			}
		} else {
			if (selected != null) {
				selected.setSelected(false);
				selected = null;
			}
		}
	}
	
	public void checkHit(){
		// check if something hit player
		// check if target hit each other
		for(int i=0;i<targets.size();i++){
			Target t = targets.get(i);
			for(int j=i+1;j<targets.size();j++){
				Target t2 = targets.get(j);
				if(t.hit(t2.getX(), t2.getY(), t2.getRadius())){
					t2.setDestroyed(true);
				}
			}
		}
	}
}
