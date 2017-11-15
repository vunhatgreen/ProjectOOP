package game;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.Handler;
import game.ID;
import object.Player;

public class Play extends BasicGameState{
	protected Handler handler = new Handler();
	public Play(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		handler.init(gc, sbg); 
		//Add object here
		handler.addObject(new Player(10, 10, ID.Player, handler));
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		handler.render(gc, sbg, g);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		handler.update(gc, sbg, delta);
	}

	public int getID() {
		return 1;
	}

}
