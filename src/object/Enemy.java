package object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import code.*;
import game.*;

public class Enemy extends GameObject{

//VARIABLE _______________________________________________________	
		
		private Handler handler;
		public Enemy(int x, int y, ID id, Handler handler) {
			super(x, y, id, handler);
			velX = 0;
			velY = 4;
			this.handler = handler;
		}
		public int health = 50;
		private Random r = new Random();
	
		
//MASK ____________________________________________________________
		
		public Rectangle getBounds() {
			return new Rectangle(x, y, 50, 60);
		}

		
//PROCESS _________________________________________________________	
		
		public void tick() {
			x += velX;
			y += velY;
			if(health <= 0 || y > Game.HEIGHT) {
				handler.removeObject(this);
				handler.addObject(new Explode(x, y, ID.Explode, handler));
		//Carry object
				if(r.nextInt(4)%2 == 0) handler.addObject(new Heal(x+15, y, ID.Heal, handler));
				if(r.nextInt(9)%3 == 0) handler.addObject(new Power(x+15, y, ID.Power, handler));
			}
			

		//Collision
			for(int i = 0; i < handler.object.size(); i++) {
				GameObject tempObj = handler.object.get(i);
				//with bullet	
					if(tempObj.getId() == ID.Bullet) 
						if(this.getBounds().intersects(tempObj.getBounds())) {
							this.health -= 10;
							handler.removeObject(tempObj);
						}
				//with player	
					if(tempObj.getId() == ID.Player) 
						if(this.getBounds().intersects(tempObj.getBounds())) {
							handler.removeObject(this);
						}		
			
			}
		
		}
		
		
//RENDER ___________________________________________________________
		
		public void render(Graphics g) {
		//Object sprite
			if(id == ID.Enemy) //g.setColor(Color.RED);
			
			new AddImage(x, y, 50, 60, "res//img//spr//enemy1.png", g);
//			new AddHealthBar(x+10, y-10, 25, 5, health, g);
		}
	}
				