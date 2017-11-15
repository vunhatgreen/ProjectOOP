package state;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.Main;

import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState{
	
//CREATE_________________________________________________________________________________________________________
	
	
	int xpos;
	int ypos;
	
	public Menu(int state) {
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	}

	
//RENDER_________________________________________________________________________________________________________
	
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
//		g.fillOval(75, 100, 100, 100);
		g.drawImage(new Image("res/img/bg/menubg.jpg"), 0, 0);
		g.drawString("NEVERWING VERSION 0.1", Main.WIDTH/2-100, 70);
		g.drawString("Press SPACE to continue", Main.WIDTH/2-100, Main.HEIGHT-100);
//		g.drawString(xpos + " " + ypos, 200, 200);
	}
	
	
//UPDATE_________________________________________________________________________________________________________
	
	
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		xpos = Mouse.getX();
		ypos = Mouse.getY();
		if((xpos > 75 && xpos <175) && (ypos > 280 && ypos < 380)) {
			if(input.isMouseButtonDown(0)) {
				sbg.enterState(1);
			}
		}
		if(input.isKeyDown(input.KEY_SPACE))
			sbg.enterState(1);
	}
	
	
//ID_____________________________________________________________________________________________________________
	
	
	public int getID() {
		return 0;
	}

}
