package object;

import java.awt.Graphics;
import java.awt.Rectangle;

import code.*;
import game.*;

public class EnemyBoss extends GameObject{

//VARIABLE _______________________________________________________	
		
		private Handler handler;
		public EnemyBoss(int x, int y, ID id, Handler handler) {
			super(x, y, id, handler);
			velX = 1;
			velY = 1;
			this.handler = handler;
		}
		public int health = 100;
		private int timer = 0;
	
		
//MASK ____________________________________________________________
		
		public Rectangle getBounds() {
			return new Rectangle(x, y, 100, 100);
		}

		
//PROCESS _________________________________________________________	
		
		public void tick() {
			
			if(y < 50) y += velY;
			else {
				x += velX;
				if(x != new Block(x, 10, Game.WIDTH-110).clamp()) velX *= -1;
				//Fire
				if(timer++ % 100 == 0) {
					handler.addObject(new EnemyBullet(x+25, y+90, ID.EnemyBullet, handler));
					handler.addObject(new EnemyBullet(x+70, y+90, ID.EnemyBullet, handler));
				}	
			}
		
			
			
			
			//If out of health
			if(health <= 0) {
				handler.removeObject(this);
		//Carry object
				handler.addObject(new Heal(x+15, y, ID.Heal, handler));
			}
			

		//Collision
			for(int i = 0; i < handler.object.size(); i++) {
				GameObject tempObj = handler.object.get(i);
				//with bullet	
					if(tempObj.getId() == ID.Bullet) 
						if(this.getBounds().intersects(tempObj.getBounds())) {
							this.health -= 1;
							handler.removeObject(tempObj);
						}
			
			}
		
		}
		
		
//RENDER ___________________________________________________________
		
		public void render(Graphics g) {
		//Object sprite
			if(id == ID.EnemyBoss) //g.setColor(Color.RED);
			
			new AddImage(x, y, 100, 100, "res//img//spr//boss.png", g);
			new AddHealthBar(Game.WIDTH/2-100, 15, 200, 15, health, g);
			new AddString(Game.WIDTH/2-5, 27, "#FFFFFF", health+"%", g);
		}
	}
				