package game;
import java.util.LinkedList;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

//Carry all the object into state
public class Handler {
	public LinkedList<Object> object = new LinkedList<Object>();
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		for(int i = 0; i < object.size(); i++) {
			Object tmpObj = object.get(i);			
				tmpObj.init(gc, sbg);	
		}
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		for(int i = 0; i < object.size(); i++) {
			Object tmpObj = object.get(i);
				tmpObj.render(gc, sbg, g);;
		}
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		for(int i = 0; i < object.size(); i++) {
			Object tmpObj = object.get(i);
				tmpObj.update(gc, sbg, delta);
		}
	}
	
	public void addObject(Object object) {
		this.object.add(object);
	}
	
	public void removeObject(Object object) {
		this.object.remove(object);
	}
}
