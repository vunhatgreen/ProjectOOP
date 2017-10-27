package game;

import java.awt.Graphics;
import java.util.Random;

import object.Enemy;
import object.EnemyBoss;

public class Spawn {
	
//VARIABLE _______________________________________________________
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int timer = 0;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	

	
//PROCESS ________________________________________________________	
	
	public void tick() {
		timer++;
		if(timer == 300) {
			timer = 0;
			HUD.LEVEL++;
		
		//Level 1
			if(HUD.LEVEL == 1) {
				handler.addObject(new Enemy(r.nextInt(10)*((Game.WIDTH-32)/10), 0-32, ID.Enemy, handler));
			}
			if(HUD.LEVEL == 2) {
				handler.addObject(new Enemy(r.nextInt(10)*((Game.WIDTH-32)/10), 0-32, ID.Enemy, handler));
				handler.addObject(new Enemy(r.nextInt(10)*((Game.WIDTH-32)/10), 0-32, ID.Enemy, handler));
			}
			if(HUD.LEVEL == 3) {
				handler.addObject(new Enemy(r.nextInt(10)*((Game.WIDTH-32)/10), 0-32, ID.Enemy, handler));
				handler.addObject(new Enemy(r.nextInt(10)*((Game.WIDTH-32)/10), 0-32, ID.Enemy, handler));
				handler.addObject(new Enemy(r.nextInt(10)*((Game.WIDTH-32)/10), 0-32, ID.Enemy, handler));
			}
			if(HUD.LEVEL == 4) {
				handler.addObject(new Enemy(r.nextInt(10)*((Game.WIDTH-32)/10), 0-32, ID.Enemy, handler));
				handler.addObject(new Enemy(r.nextInt(10)*((Game.WIDTH-32)/10), 0-32, ID.Enemy, handler));
				handler.addObject(new Enemy(r.nextInt(10)*((Game.WIDTH-32)/10), 0-32, ID.Enemy, handler));
			}
			if(HUD.LEVEL == 5) {
				handler.addObject(new EnemyBoss(Game.WIDTH/2-50, 0-100, ID.EnemyBoss, handler));
			}

	
		}
	}
}
