package Game;

import java.util.ArrayList;

import util.Configuration;
import util.TimeUtility;

public class TargetSpawner {
	private static int spawnDelayCounter = 0;
	private static boolean canSpawnNewTarget = true;
	private static double SPAWN_DELAY_REDUCE_RATE_PER_TICK = 0.002;

	public static int getSpawnMultiplyer() {
		if (TimeUtility.getEscalatedTime()%350000 >= 52500 && TimeUtility.getEscalatedTime()%350000 <= 57225) {
			return 0;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 57225 && TimeUtility.getEscalatedTime()%350000 <= 57225+500) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 59435 && TimeUtility.getEscalatedTime()%350000 <= 59435+500) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 63535 && TimeUtility.getEscalatedTime()%350000 <= 63535+500) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 69735 && TimeUtility.getEscalatedTime()%350000 <= 69735+500) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 73235 && TimeUtility.getEscalatedTime()%350000 <=  73235+500) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime()%350000 >=76435 && TimeUtility.getEscalatedTime()%350000 <= 76435+500) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 79435 && TimeUtility.getEscalatedTime()%350000<= 79435+500) {
			return 30;
		}
		//bass drop second
		if (TimeUtility.getEscalatedTime()%350000 >= 109000 && TimeUtility.getEscalatedTime()%350000<= 109000+500) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 113000 && TimeUtility.getEscalatedTime()%350000<= 113000+500) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 116000 && TimeUtility.getEscalatedTime()%350000<= 116000+500) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 119000 && TimeUtility.getEscalatedTime()%350000<= 119000 +500) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 122000 && TimeUtility.getEscalatedTime()%350000<= 122000+500) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 125800 && TimeUtility.getEscalatedTime()%350000<= 125800+500) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 132400 && TimeUtility.getEscalatedTime()%350000<= 132400+500) {
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
