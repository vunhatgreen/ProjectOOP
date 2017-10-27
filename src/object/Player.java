package object;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import code.*;
import game.*;

public class Player extends GameObject{
	
//VARIABLE _______________________________________________________	
	
	private int timer;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		velX = 0;
	}

	
//MASK ___________________________________________________________

	public Rectangle getBounds() {
		return new Rectangle(x, y, 60, 50);
	}
	
	
//PROCESS _________________________________________________________
	
	public void tick() {
		x += velX;
		y += velY;
		x = new Block(x, 0, Game.WIDTH-60).clamp();
		y = new Block(y, 30, Game.HEIGHT-130).clamp();
		
		//Fire
		if(HUD.POWER == 1)
			if(timer++ % 10 == 0) handler.addObject(new Bullet(x+20, y-15, ID.Bullet, handler));
		if(HUD.POWER == 2)
			if(timer++ % 9 == 0) {
				handler.addObject(new Bullet(x+20, y-15, ID.Bullet, handler));
			}
		if (HUD.POWER == 3)
			if(timer++ % 9 == 0) {
				handler.addObject(new Bullet(x+10, y-15, ID.Bullet, handler));
				handler.addObject(new Bullet(x+30, y-15, ID.Bullet, handler));
			}
		if (HUD.POWER == 4)
			if(timer++ % 8 == 0) {
				handler.addObject(new Bullet(x+10, y-15, ID.Bullet, handler));
				handler.addObject(new Bullet(x+30, y-15, ID.Bullet, handler));
			}
		if (HUD.POWER == 5)
			if(timer++ % 8 == 0) {
				handler.addObject(new Bullet(x+5, y-15, ID.Bullet, handler));
				handler.addObject(new Bullet(x+20, y-15, ID.Bullet, handler));
				handler.addObject(new Bullet(x+35, y-15, ID.Bullet, handler));
			}
		//Collision
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);
			//with enemy	
			if(tempObj.getId() == ID.Enemy) 
				if(this.getBounds().intersects(tempObj.getBounds())) {
					HUD.HEALTH -= 25;
				}		
			//with enemy	
			if(tempObj.getId() == ID.EnemyBullet) 
				if(this.getBounds().intersects(tempObj.getBounds())) {
					handler.removeObject(tempObj);
					HUD.HEALTH -= 10;
				}
			//with enemyboss	
			if(tempObj.getId() == ID.EnemyBoss) 
				if(this.getBounds().intersects(tempObj.getBounds())) {
					HUD.HEALTH -= 1;
				}
		}
	}
	
	
//RENDER ___________________________________________________________
	
	public void render(Graphics g) {
	//Object sprite
		
		if(id == ID.Player) new AddImage(x, y, 50, 60, "res//img//spr//plane.png", g);
		else {
			g.setColor(Color.WHITE);
			g.fillRect(x,y,32,32);
		}

		//new AddString(x+40, y+10, "#FFFFFF", "P1", g);
	}
}
																																																																										