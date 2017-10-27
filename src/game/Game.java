package game;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import code.*;
import object.*;

public class Game extends Canvas implements Runnable{

//VARIABLE ___________________________________________________________	
	
	private static final long serialVersionUID = 1L;
	public static final String NAME = "Neverwing v1.0";
	public static final int WIDTH = 800/2;
	public static final int HEIGHT = 1280/2;
	
	private boolean running = false;

	private Thread thread;
	private Handler handler;
	
	private HUD hud;
	private Background background;
	private Spawn spawner;
	
//OBJECT _____________________________________________________________
	
	public Game() {
		new AddFrame(WIDTH, HEIGHT, NAME, false, this);
		handler = new Handler();	
		background = new Background();
		hud = new HUD();	
		spawner = new Spawn(handler, hud);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseMotionListener(new MouseInput(handler));
		
	//Add Object		
		handler.addObject(new Player(WIDTH/2-25, HEIGHT*4/5, ID.Player, handler));
		
	}

	
//SYSTEM _____________________________________________________________
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run()
    {
		requestFocus(); //Focus on the frame right after run the game
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D;
		int ticks = 0;
		int frames = 0;
		long lastTimer = System.currentTimeMillis();
		double delta =0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now-lastTime)/nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			while (delta >= 1) {
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}
			try {
			Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(shouldRender) {
				frames++;
				render();
			}
			if(System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println("Tick: " + ticks + ", Frames: " + frames);
				frames = 0;
				ticks = 0;
			}
		}
	}
	

	
	private void tick() {
		background.tick();
		handler.tick();
		hud.tick();
		spawner.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		background.render(g);
		handler.render(g);		
		hud.render(g);
		g.dispose();
		bs.show();
	}
	

//MAIN _______________________________________________________________
	
	public static void main(String[] args)	
	{
		new Game();
	}
}

