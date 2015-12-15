package game;

import java.util.ArrayList;
import java.util.Iterator;

import button.BackButton;
import util.InputUtility_Game;

public class GameLogic {
	protected ArrayList<Target> targets;
	private Target selected;
	private button.BackButton backButton;

	public GameLogic() {
		targets = new ArrayList<Target>();
		selected = null;
		backButton = new BackButton();
		RenderableHolder.add(backButton);
	}

	public void logicUpdate() {
		backButton.update();
		if (Player.getInstance().isDead()) {
			GameManager.getInstance().endGame();
		}
		if (Player.getInstance().useSkill) {
			addSkill();
		}
		Player.getInstance().update();
		selectionHandler(); // a function handle mouse Target selection
		checkHit();
		for (Iterator<Target> itr = targets.iterator(); itr.hasNext();) {
			Target t = itr.next();
			if (t.isDestroyed()) {
				itr.remove();
			} else {
				t.update();
			}
		}
		TargetSpawner.spawnNewTarget(targets);
		InputUtility_Game.update();

	}

	public void selectionHandler() {
		if (InputUtility_Game.getMouseLeftDown()) {
			if (selected == null) {
				for (Target t : targets) {
					if (t.isMouseOver()) {
						selected = t;
						t.setSelected(true);
						break;
					}
				}
			} else if (selected.isDestroyed()) {
				selected = null;
			}
		} else {
			if (selected != null) {
				selected.setSelected(false);
				selected = null;
			}
		}
	}

	public void checkHit() {
		// check if something hit player
		for (int i = 0; i < targets.size(); i++) {
			Target t = targets.get(i);
			if (t.canHitPlayer && Player.getInstance().hit(t.getX(), t.getY(), t.getRadius())) {
				t.setCanScore(false);
				t.destroy();
			}
		}
		// check if target hit each other
		for (int i = 0; i < targets.size(); i++) {
			Target t = targets.get(i);
			for (int j = i + 1; j < targets.size(); j++) {
				Target t2 = targets.get(j);
				if (t.hit(t2.getX(), t2.getY(), t2.getRadius())) {
					if (t instanceof PlayerSkill || t2 instanceof PlayerSkill) {
						t.setCanScore(false);
						t2.setCanScore(false);
					}
					t.destroy();
					t2.destroy();
				}
			}
		}
	}

	private void addSkill() {
		Target t = new PlayerSkill();
		targets.add(t);
		RenderableHolder.addFront(t);
	}
}