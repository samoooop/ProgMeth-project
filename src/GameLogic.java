import java.util.ArrayList;

import render.IRenderable;

public class GameLogic {
	private static GameLogic instance = new GameLogic();
	protected ArrayList<MovingObject> movingObject;
	private static final int SPAWN_DELAY = 100;
	private int spawnDelayCounter;

	public GameLogic() {

		movingObject = new ArrayList<MovingObject>();
		spawnDelayCounter = 0;
	}

	public static GameLogic getInstance() {
		return instance;
	}

	public void logicUpdate() {
		for (int i = 0; i < movingObject.size(); i++) {
			movingObject.get(i).update();
			for (int j = 0; j < movingObject.size(); j++) {
				if (movingObject.get(i).collideWith(movingObject.get(j))) {
					movingObject.get(i).setDestroyed(true);
				}
			}
			if (movingObject.get(i).isDestroyed()) {
				movingObject.remove(i);
				i--;
			}

		}

		
		spawnDelayCounter++;
		if (spawnDelayCounter >= SPAWN_DELAY) {
			spawnDelayCounter = 0;
			MovingObject a = new MovingObject();
			movingObject.add(a);
			RenderableHolder.getInstance().getEntities().add(a);

		}

	}

}
