package object;

import java.awt.Rectangle;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.*;
import game.Object;
import support.*;

public class HUD extends Object{
	

//CREATE_________________________________________________________________________________________________________
	
	
	public static int TIMER = 0;
	public static int WAVE = 0;
	public static int LIVE = 3;
	private static int SCORE = 0;
	
	public HUD(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
	}


	public Rectangle getBounds() {
		return null;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}
	

//RENDER_________________________________________________________________________________________________________
	
	
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		for(int i = 0; i < HUD.LIVE; i++) {
			g.drawImage(new Image("res/img/spr/lives.png"), 15+i*20, Main.HEIGHT-30);
		}
		
		g.drawString(String.format("%06d", SCORE), Main.WIDTH-70, Main.HEIGHT-30);
	}
	

//UPDATE_________________________________________________________________________________________________________

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		TIMER++;
	}


}