package game;
import java.awt.Rectangle;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public abstract class Object {
	protected float x, y;
	protected ID id;
	protected float velX, velY;
	protected Handler handler;
	
	public Object(float x, float y, ID id, Handler handler) {
		this.x = x;
		this.y = y; 
		this.id = id;
		this.handler = handler;
	}
	
	public abstract Rectangle getBounds();
	public abstract void init(GameContainer gc, StateBasedGame sbg) throws SlickException;
	public abstract	void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException;
	public abstract void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException;
	
	public ID getId() {
		return id;
	}

	
}
