package game;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import state.Menu;
import state.Game;

public class Main extends StateBasedGame{

	public static final String TITLE = "NeverWings";
	public static final int WIDTH = 450;
	public static final int HEIGHT = 700;
	
	
	public static final int MENU = 0;
	public static final int GAME = 1;

	public Main(String TITLE) {
		super(TITLE);
		this.addState(new Menu(MENU));
		this.addState(new Game(GAME));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {

		this.getState(MENU).init(gc, this);
		this.getState(GAME).init(gc, this);
		this.enterState(MENU); //First screen to start
		
	}
	
	public static void main(String[] args) {
		
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Main(TITLE));
			appgc.setDisplayMode(WIDTH, HEIGHT, false);
			appgc.setMouseGrabbed(false);
			appgc.setTargetFrameRate(60);
//			appgc.setShowFPS(false);
			appgc.start();
		} catch(SlickException e) {
			e.printStackTrace();
		}
		
	}



}
