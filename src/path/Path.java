package path;

import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.Handler;
import game.*;
import object.*;


public class Path {
	

//CREATE_________________________________________________________________________________________________________
	
	
	private Handler handler;
	private Random r = new Random();
	
	public static int TIMER = 0;
	
	public Path(Handler handler) {
		this.handler = handler;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}
	
	

//UPDATE_________________________________________________________________________________________________________

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		TIMER++;
	
		if(TIMER == 300) {
			HUD.WAVE++;
			TIMER = 0;
			System.out.println(TIMER);
		//Level 1
			if(HUD.WAVE == 1) {
				handler.addObject(new Enemy(1*((Main.WIDTH-50)/4), 0-32, ID.Enemy1, handler));
			}
			if(HUD.WAVE == 2) {
				handler.addObject(new Enemy(0*((Main.WIDTH-50)/4), 0-32, ID.Enemy1, handler));
				handler.addObject(new Enemy(3*((Main.WIDTH-50)/4), 0-32, ID.Enemy1, handler));
			}
			if(HUD.WAVE == 3) {
				handler.addObject(new Enemy(r.nextInt(10)*((Main.WIDTH-32)/10), 0-32, ID.Enemy1, handler));
				handler.addObject(new Enemy(r.nextInt(10)*((Main.WIDTH-32)/10), 0-32, ID.Enemy1, handler));
				handler.addObject(new Enemy(r.nextInt(10)*((Main.WIDTH-32)/10), 0-32, ID.Enemy1, handler));
			}
			if(HUD.WAVE == 4) {
				handler.addObject(new Enemy(r.nextInt(10)*((Main.WIDTH-32)/10), Main.HEIGHT + 250, ID.Enemy2, handler));
			}
			if(HUD.WAVE == 6) {
				handler.addObject(new EnemyBoss(Main.WIDTH/2-150, 0-100, ID.EnemyBoss1, handler));
			} 
			
		}
	}
}