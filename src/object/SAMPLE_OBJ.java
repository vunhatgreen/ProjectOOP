package object;

import java.awt.Rectangle;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.*;
import game.Object;
import support.*;

public class SAMPLE_OBJ extends Object{
	

//CREATE_________________________________________________________________________________________________________
	
	
	public SAMPLE_OBJ(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
	}


	public Rectangle getBounds() {
		return null;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	}
	

//RENDER_________________________________________________________________________________________________________
	
	
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
	}
	

//UPDATE_________________________________________________________________________________________________________

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	}


}