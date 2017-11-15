package object;

import java.awt.Rectangle;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.*;
import game.Object;
import support.Block;
import support.HealthBar;

public class EnemyBoss extends Object{
	

//CREATE_________________________________________________________________________________________________________
	
	
	private int health = 100;
	private float velY = 0.1f;
	private float velX = 0.05f;
	public EnemyBoss(float x, float y, ID id, Handler handler) {
		super(x, y, id, handler);
	}


	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	}
	

//RENDER_________________________________________________________________________________________________________
	
	
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if(id == ID.EnemyBoss1) {
			g.drawImage(new Image("res/img/spr/enemyBoss.png"), x, y);
			new HealthBar(Main.WIDTH/2-125, 15, 250, 17, health, g);
			g.drawString(health+"%", Main.WIDTH/2-8, 15);
		}
	}
	

//UPDATE_________________________________________________________________________________________________________

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(id == ID.EnemyBoss1) {
			health = (int) new Block(health, 0, 100).clamp();
			if(y < 70) y += velY*delta;
			else {
				if(x > Main.WIDTH - 300|| x < 10) velX *= -1;
				x += velX*delta;
				
				//Fire
//				if(timer++ % 100 == 0) {
//					handler.addObject(new EnemyBullet(x+25, y+90, ID.EnemyBullet, handler));
//					handler.addObject(new EnemyBullet(x+70, y+90, ID.EnemyBullet, handler));
				}	
			}
		
		
		if(y > Main.HEIGHT) {
			handler.removeObject(this);
		}
	//Carry object
//			if(r.nextInt(4)%2 == 0) handler.addObject(new Heal(x+15, y, ID.Heal, handler));
//			if(r.nextInt(9)%3 == 0) handler.addObject(new Power(x+15, y, ID.Power, handler));
			
		
		
	}


}