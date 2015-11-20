import java.util.ArrayList;

import render.IRenderable;


public class GameLogic {
private static GameLogic instance =  new GameLogic();
protected ArrayList<MovingObject> MovingObject;
private static final  int SPAWN_DELAY = 100;
private int spawnDelayCounter;
public GameLogic(){
	
	MovingObject = new ArrayList<MovingObject>();
	spawnDelayCounter  =0;
}
public static GameLogic getInstance() {
	return instance;
}
public void logicUpdate(){
	for(int i = 0 ;i <MovingObject.size();i++){
		MovingObject.get(i).update();
		for(int j = 0 ;j <MovingObject.size();j++ ){
			if(MovingObject.get(i).collideWith(MovingObject.get(j))){
				MovingObject.get(i).setDestroyed(true);
			}
		}
	   if(MovingObject.get(i).isDestroyed() ){
		   MovingObject.remove(i);
		   i--;
	   }
	   
	
	
	
	
	
	}
	
	ArrayList <IRenderable> temp = RenderableHolder.getInstance().getEntities();
	for (int i = 0; i < temp.size(); i++) {
		if (temp.get(i) instanceof MovingObject) {
			if (((MovingObject) temp.get(i)).isDestroyed()) {
				temp.remove(i);
				i--;
			}
		}
	}

	spawnDelayCounter ++;
	if(spawnDelayCounter >= SPAWN_DELAY){
		spawnDelayCounter = 0;
		MovingObject a = new MovingObject();
		MovingObject.add(a);
		RenderableHolder.getInstance().getEntities().add(a);
		
	}
	
}



}
