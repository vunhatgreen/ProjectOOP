package com.mygdx.game;

import javax.print.attribute.standard.MediaSize.Other;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import object.Enemy;
import object.Player;
import framework.BulletManager;
import framework.CollisionHandler;
import framework.EnemyManager;

public class MyGdxGame extends ApplicationAdapter {
	public static SpriteBatch batch;
	public static float screenWidth;
	public static float screenHeight;
	
	public Player player;
	private Texture background;
	private Texture menuBackground;
	
	public enum State{
		MENU,
		GAME,
		GAMEOVER;
	};
	
	public static State state = State.MENU;
	
	Music music;

	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
		background = new Texture("nebula.jpg");
		menuBackground = new Texture("menu.gif");
		player = new Player();
		music = Gdx.audio.newMusic(Gdx.files.internal("Star Wars Soundtrack.mp3"));	
		
	}

	public void update() {
		
		music.play();
		if (state == State.GAME) {
			player.update();
		}
		if (state == State.MENU && Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			state = State.GAME;
		}
		if (state == State.GAMEOVER && Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			player = new Player();
			state = State.MENU;
		}
		if (Gdx.input.isKeyJustPressed(Keys.Q) || Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		
	}
	
	@Override
	public void render () {
		
		update();
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		if (state == State.MENU) {
			batch.draw(menuBackground, 0, 0);
		} else if (state == State.GAME) {
			batch.draw(background, 0, 0);
			player.render();
		} else if (state == State.GAMEOVER) {
			new GameOver(player).render();
			music.stop();
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		music.dispose();
		background.dispose();
		menuBackground.dispose();
	}
}
