package object;

import java.awt.Rectangle;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.*;
import game.Object;
import support.*;

public class Item extends Object{
	

//CREATE_________________________________________________________________________________________________________
	
	private int timer;
	private final int WIDTH = 15;
	private final int HEIGHT = 20;
	
	public Item(float x, float y, ID id, Handler handler) {
		super(x, y, id, handler);
	}


	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 15, 20);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	}
	

//RENDER_________________________________________________________________________________________________________
	
	
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		if(id == ID.Heal) g.drawImage(new Image("res/img/spr/heal.png"), x, y);
		if(id == ID.Power) g.drawImage(new Image("res/img/spr/power.png"), x, y);
		
	}
	

//UPDATE_________________________________________________________________________________________________________

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		x += velX;
		y += velY + timer++/3;

		
		if(y > Main.HEIGHT) {
			handler.removeObject(this);
		}
		
		
	}


}