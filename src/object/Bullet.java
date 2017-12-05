package object;

import java.awt.Rectangle;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.*;
import game.Object;

public class Bullet extends Object{
	

//CREATE_________________________________________________________________________________________________________
	private final int WIDTH = 16;
	private final int HEIGHT = 18;
	
	public Bullet(float x, float y, ID id, Handler handler) {
		super(x, y, id, handler);
		velY = -10;
	}


	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y, this.WIDTH, this.HEIGHT);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	}
	

//RENDER_________________________________________________________________________________________________________
	
	
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(new Image("res/img/spr/bullet.png"), x, y);
	}
	

//UPDATE_________________________________________________________________________________________________________

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		x += velX;
		y += velY;
		if(y < 0) {
			handler.removeObject(this);
		}
	
	}


}