
public class RandomUtility {
public RandomUtility(){}
public static int random(int a ,int b ){
	int c = a +(int) (Math.random()*(b-a+1));
	return c;
	
}
}
