package object;
import java.awt.Graphics;
import java.awt.Rectangle;

import code.*;
import game.*;

public class Bullet extends GameObject{

//VARIABLE ________________________________________________________
	
	public Bullet(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		velY = -10;	//speed
	}
	
	
//MASK ____________________________________________________________
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 30);
	}	
	
	
//PROCESS _________________________________________________________	
	
	public void tick() {
		x += velX;
		y += velY;

		
		if(y < 0) {
			handler.removeObject(this);
		}
	}
	
	
//RENDER ____________________________________________________________
	public void render(Graphics g) {
	//Object sprite
		new AddImage(x, y, 10, 15, "res//img//spr//bullet.png", g);
		
	}
}
																																																																										