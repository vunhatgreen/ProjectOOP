package state;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.Handler; 
import game.ID;
import game.Main;
import object.*;
import path.Path;

public class Game extends BasicGameState{
	
//CREATE_________________________________________________________________________________________________________

	
	protected Handler handler = new Handler();
	private Path path = new Path(handler);

	public Game(int state) {
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		handler.init(gc, sbg); 
		//Add object here
		handler.addObject(new HUD(0, 0, ID.HUD, handler));
		handler.addObject(new Player(Main.WIDTH/2-50, Main.HEIGHT-300, ID.Player, handler));
	}
	

//RENDER_________________________________________________________________________________________________________

	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		handler.render(gc, sbg, g);
		
	}
	
//UPDATE_________________________________________________________________________________________________________

	
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		path.update(gc, sbg, delta);
		handler.update(gc, sbg, delta);
	}


//ID_____________________________________________________________________________________________________________
	
	
	public int getID() {
		return 1;
	}

}
