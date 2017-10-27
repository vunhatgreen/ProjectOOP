package code;

import game.GameObject;
import game.Handler;
import game.ID;

public class BetweenObj {
	private Handler handler;
	private String obj1;
	private String obj2;
	private GameObject tempObj1;
	private GameObject tempObj2;
	
	public BetweenObj(String obj1, String obj2, Handler handler) {
		this.obj1 = obj1;
		this.obj2 = obj2;
		this.handler = handler;
	}
	
	public void getObject() {
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.valueOf(obj1)) 
				tempObj1 = handler.object.get(i);
			if(handler.object.get(i).getId() == ID.valueOf(obj2)) 
				tempObj2 = handler.object.get(i);
		}
	}
	public double distance() {
		getObject();
		return Math.sqrt(Math.pow((tempObj1.getX()-tempObj2.getX()), 2) + Math.pow((tempObj1.getY()-tempObj2.getY()), 2));
	}
}
