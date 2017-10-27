package code;

import game.*;

public class Collision {
	private Handler handler = new Handler();
	private String obj1;
	private String obj2;

	
	public Collision(String obj1, String obj2, Handler handler) {
		this.handler = handler;
		this.obj1 = obj1;
		this.obj2 = obj2;
		check();
	}

	public boolean check() {
		boolean checked = false;
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj1 = handler.object.get(i);
			for(int j = 0; j < handler.object.size(); j++) {
				GameObject tempObj2 = handler.object.get(j);
				if(tempObj1.getId() == ID.valueOf(obj1) && tempObj2.getId() == ID.valueOf(obj2)) {
					if(tempObj1.getBounds().intersects(tempObj2.getBounds())) {
						checked = true;
					}
				}
			}
		}
		return checked;
	}
}
