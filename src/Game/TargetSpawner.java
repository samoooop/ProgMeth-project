package Game;

import java.util.ArrayList;

import util.Configuration;
import util.TimeUtility;

public class TargetSpawner {
	private static int spawnDelayCounter = 0;
	private static boolean canSpawnNewTarget = true;
	private static double SPAWN_DELAY_REDUCE_RATE_PER_TICK = 0.002;

	private static int getSpawnMultiplyer() {
		if (TimeUtility.getEscalatedTime() >= 55000 && TimeUtility.getEscalatedTime() <= 60000) {
			return 0;
		}
		if (TimeUtility.getEscalatedTime() >= 60000 && TimeUtility.getEscalatedTime() <= 65000) {
			return 3;
		}
		return 1;
	}

	private static int getSpawnDelay(){
		return Configuration.SPAWN_DELAY - (int)(TimeUtility.getTick()*SPAWN_DELAY_REDUCE_RATE_PER_TICK);
	}

	public static void spawnNewTarget(ArrayList<Target> targets) {
		if(!canSpawnNewTarget){
			return;
		}
		if (spawnDelayCounter >= getSpawnDelay()) {
			spawnDelayCounter = 0;
		} else {
			spawnDelayCounter++;
			return;
		}
		int n = getSpawnMultiplyer();
		System.out.println(n + " " +TimeUtility.getTick() +" "+ TimeUtility.getEscalatedTime() + " " +getSpawnDelay() + " " + (int)(TimeUtility.getTick()*SPAWN_DELAY_REDUCE_RATE_PER_TICK));
		while(n>0){
			Target t = new Target();
			targets.add(t);
			RenderableHolder.addBack(t);
			n--;
		}
	}
}
