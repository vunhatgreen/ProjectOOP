package object;
import java.awt.Graphics;
import java.awt.Rectangle;

import code.*;
import game.*;

public class EnemyBullet extends GameObject{

//VARIABLE ________________________________________________________
	
	private int timer = 0;
	public EnemyBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		velY = 1;	//speed
	}
	
	
//MASK ____________________________________________________________
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 10, 15);
	}	
	
	
//PROCESS _________________________________________________________	
	
	public void tick() {
		timer++;
		x += velX;
		y += velY*timer/5;

		
		if(y > Game.HEIGHT) {
			handler.removeObject(this);
		}
	}
	
	
//RENDER ____________________________________________________________
	public void render(Graphics g) {
	//Object sprite
		new AddImage(x, y, 10, 15, "res//img//spr//enemybullet.png", g);
		
	}
}
																																																																										