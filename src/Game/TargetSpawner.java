package Game;

import java.util.ArrayList;

import util.Configuration;
import util.TimeUtility;

public class TargetSpawner {
	private static int spawnDelayCounter = 0;
	private static boolean canSpawnNewTarget = true;
	private static double SPAWN_DELAY_REDUCE_RATE_PER_TICK = 0.002;

	private static int getSpawnMultiplyer() {
		if (TimeUtility.getEscalatedTime()%350000 >= 52500 && TimeUtility.getEscalatedTime()%350000 <= 57225) {
			return 0;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 57225 && TimeUtility.getEscalatedTime()%350000 <= 57225+500) {
			return 20;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 59435 && TimeUtility.getEscalatedTime()%350000 <= 59435+500) {
			return 20;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 63535 && TimeUtility.getEscalatedTime()%350000 <= 63535+500) {
			return 20;
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
		if (TimeUtility.getEscalatedTime()%350000 >= 119225 && TimeUtility.getEscalatedTime()%350000<=119225+500) {
			return 30;
		}
		if (TimeUtility.getEscalatedTime()%350000 >= 107225 && TimeUtility.getEscalatedTime()%350000<= 107225+500) {
			return 30;
		}
		
		if (TimeUtility.getEscalatedTime()%350000 >= 110725&& TimeUtility.getEscalatedTime()%350000<=  110725+500) {
			return 30;
		}
		
		if (TimeUtility.getEscalatedTime()%350000 >=112725 && TimeUtility.getEscalatedTime()%350000<= 112725+500) {
			return 30;
		}
		
		if (TimeUtility.getEscalatedTime()%350000 >= 117225 && TimeUtility.getEscalatedTime()%350000<=117225+500) {
			return 30;
		}
		
		if (TimeUtility.getEscalatedTime()%350000 >= 120725 && TimeUtility.getEscalatedTime()%350000<= 120725+500 ) {
			return 30;
		}
		
		if (TimeUtility.getEscalatedTime()%350000 >= 124725 && TimeUtility.getEscalatedTime()%350000<= 124725+500) {
			return 30;
		}
		
		if (TimeUtility.getEscalatedTime()%350000 >= 127225 && TimeUtility.getEscalatedTime()%350000<= 132725+500) {
			return 30;
		}
		
		if (TimeUtility.getEscalatedTime()%350000 >= 180525 && TimeUtility.getEscalatedTime()%350000<= 180525+500) {
			return 30;
		}
		
		if (TimeUtility.getEscalatedTime()%350000 >= 172725 && TimeUtility.getEscalatedTime()%350000<= 172725 +500) {
			return 30;
		}
		
		if (TimeUtility.getEscalatedTime()%350000 >=199425&& TimeUtility.getEscalatedTime()%350000<= 199425+500) {
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
