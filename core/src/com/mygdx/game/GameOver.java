package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

import object.Player;

public class GameOver {
	private Texture gameOverBackground;
	private BitmapFont gameOverFont;
	private Player player;
	private GlyphLayout layout;
	public GameOver(Player player) {
		this.player = player;
		init();
	}
	
	public void init() {
		gameOverBackground = new Texture("gameover.jpg");
		gameOverFont = new BitmapFont(Gdx.files.internal("Arial.fnt"));
		layout = new GlyphLayout(gameOverFont, "Score: " + String.valueOf(player.score));
		
	}
	
	public void render() {
		MyGdxGame.batch.draw(gameOverBackground, 0, 0);
		gameOverFont.draw(MyGdxGame.batch, layout, MyGdxGame.screenWidth / 2 - layout.width / 2 , MyGdxGame.screenHeight / 2 - layout.height / 2);
	}
}
