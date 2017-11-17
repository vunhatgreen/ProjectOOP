package object;

import java.awt.Rectangle;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.*;
import game.Object;
import path.Path;
import support.Block;

public class Player extends Object{
	

//CREATE_________________________________________________________________________________________________________
	
	
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id, handler);
	}


	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 100, 100);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	
	}
	

//RENDER_________________________________________________________________________________________________________
	
	
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(new Image("res/img/spr/plane.png"), x, y);
	}
	

//UPDATE_________________________________________________________________________________________________________

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		Input input = gc.getInput();

		/*if(x != Mouse.getX()) x = Mouse.getX();
			x = new Block(x, 5, Main.WIDTH-105).clamp();
		if(y != Mouse.getY()) y = Main.HEIGHT-Mouse.getY();
			y = new Block(y, 5, Main.HEIGHT-105).clamp();
		if(input.isMouseButtonDown(0))
			if(Path.TIMER % 10 == 0) handler.addObject(new Bullet(x+42, y-15, ID.Bullet, handler));*/
		
		
		if(input.isKeyDown(Input.KEY_UP) && y > 10) y -= delta * .3;
		if(input.isKeyDown(Input.KEY_DOWN) && y < Main.HEIGHT - 110) y += delta * .3;
		if(input.isKeyDown(Input.KEY_LEFT) && x > 10) x -= delta * .5;
		if(input.isKeyDown(Input.KEY_RIGHT) && x < Main.WIDTH - 110) x += delta * .5;
		if(input.isKeyDown(Input.KEY_SPACE)) {
			if(HUD.POWER == 1)
				if(Path.TIMER % 10 == 0) handler.addObject(new Bullet(x+42, y-15, ID.Bullet, handler));
			if(HUD.POWER >= 2)
				if(Path.TIMER % 10 == 0) {
					handler.addObject(new Bullet(x+32, y-15, ID.Bullet, handler));
					handler.addObject(new Bullet(x+52, y-15, ID.Bullet, handler));
				}
		
		}
			
		for(int i = 0; i < handler.object.size(); i++) {
			Object tempObj = handler.object.get(i);
			//with enemy	
				if(tempObj.getId() == ID.Enemy1) 
					if(this.getBounds().intersects(tempObj.getBounds())) {
						handler.removeObject(tempObj);
						HUD.LIVE--;
					}		
				if(tempObj.getId() == ID.Heal) 
					if(this.getBounds().intersects(tempObj.getBounds())) {
						handler.removeObject(tempObj);
						HUD.LIVE++;
					}
				if(tempObj.getId() == ID.Power) 
					if(this.getBounds().intersects(tempObj.getBounds())) {
						handler.removeObject(tempObj);
						HUD.POWER++;
					}
		}
		
		
	}


}