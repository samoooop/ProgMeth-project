package Game;

import java.util.ArrayList;

import util.Configuration;
import util.TimeUtility;

public class TargetSpawner {
	private static int spawnDelayCounter = 0;
	private static boolean canSpawnNewTarget = true;
	private static double SPAWN_DELAY_REDUCE_RATE_PER_TICK = 0.002;

	private static int getSpawnMultiplyer() {
		if (TimeUtility.getEscalatedTime() >= 52500 && TimeUtility.getEscalatedTime() <= 57225) {
			return 0;
		}
		if (TimeUtility.getEscalatedTime() >= 57225 && TimeUtility.getEscalatedTime() <= 58235) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime() >= 60035 && TimeUtility.getEscalatedTime() <= 61035) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime() >= 63535 && TimeUtility.getEscalatedTime() <= 64535) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime() >= 70235 && TimeUtility.getEscalatedTime() <= 71235) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime() >= 73735 && TimeUtility.getEscalatedTime() <=  74735) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime() >=76935 && TimeUtility.getEscalatedTime() <= 77935) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime() >= 80235 && TimeUtility.getEscalatedTime() <= 81235) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime() >= 110000 && TimeUtility.getEscalatedTime() <= 11000) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime() >= 189000 && TimeUtility.getEscalatedTime() <= 190000) {
			return 30;
		}

		return 1;
	}

	private static int getSpawnDelay() {
		return Configuration.SPAWN_DELAY - (int) (TimeUtility.getTick() * SPAWN_DELAY_REDUCE_RATE_PER_TICK);
	}

	public static void spawnNewTarget(ArrayList<Target> targets) {
		if (!canSpawnNewTarget) {
			return;
		}
		if (spawnDelayCounter >= getSpawnDelay()) {
			spawnDelayCounter = 0;
		} else {
			spawnDelayCounter++;
			return;
		}
		int n = getSpawnMultiplyer();
		// System.out.println(n + " " +TimeUtility.getTick() +" "+
		// TimeUtility.getEscalatedTime() + " " +getSpawnDelay() + " " +
		// (int)(TimeUtility.getTick()*SPAWN_DELAY_REDUCE_RATE_PER_TICK));
		while (n > 0) {
			Target t = new Target();
			targets.add(t);
			RenderableHolder.addBack(t);
			n--;
		}
	}

	public static void baseDrop(int millisec) {
	}

}
