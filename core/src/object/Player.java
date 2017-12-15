package object;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.MyGdxGame.State;

import framework.BulletManager;
import framework.CollisionHandler;
import framework.EnemyManager;

public class Player {
	private Texture playerTexture;
	private Vector2 playerLocation;
	private Rectangle playerBounds;
	private BitmapFont scoreText;
	private GlyphLayout scoreLayout;
	private boolean isWrongInput = false;
	private boolean isWarningOn = true;
	private CharSequence warning = "+ To move left, press LEFT ARROW\n"
								 + "+ To move right, press RIGHT ARROW\n"
								 + "+ To move up, press UP ARROW\n"
								 + "+ To move down, press DOWN ARROW\n"
								 + "+ To shoot, press SPACE\n"
								 + "+ To turn off this warning, press ENTER";
	private BitmapFont wrongInputWarning;
	private GlyphLayout wrongInputWarningLayout;
	
	public int score = 0;
	public int health = 3;
	private int level = 1;
	private int delayTime = 0;
	private Texture healthTexture;
	
	public BulletManager bulletManager;
	public EnemyManager enemyManager;
	private CollisionHandler collisionHandler;
	
	public Player() {
		init();
	}

	public Texture getPlayerTexture() {
		return playerTexture;
	}

	public Vector2 getPlayerLocation() {
		return playerLocation;
	}

	public Rectangle getBounds() {
		return playerBounds;
	}
	
	public void init() {
		playerTexture = new Texture("plane.png");
		playerLocation = new Vector2((MyGdxGame.screenWidth - playerTexture.getWidth()) / 2, 20);
		
		bulletManager = new BulletManager(this, Id.playerId);
		enemyManager = new EnemyManager();
		collisionHandler = new CollisionHandler(this, enemyManager, bulletManager);
		
		
		playerBounds = new Rectangle(playerLocation.x, playerLocation.y, playerTexture.getWidth(), playerTexture.getHeight());
		
		healthTexture = new Texture("lives.png");
		scoreText = new BitmapFont(Gdx.files.internal("Arial.fnt"));
		scoreText.getData().setScale(0.5f);
		scoreLayout = new GlyphLayout(scoreText, "Score: " + String.valueOf(score));
		wrongInputWarning = new BitmapFont(Gdx.files.internal("Arial.fnt"));
		wrongInputWarning.getData().setScale(0.6f);
		wrongInputWarningLayout = new GlyphLayout(wrongInputWarning, warning);
		
	}
	
	public void update() {
		if (Gdx.input.isKeyPressed(Keys.UP) && playerLocation.y < (MyGdxGame.screenHeight - playerTexture.getHeight() - 5)) {
			playerLocation.y += 5;
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN) && playerLocation.y > healthTexture.getHeight()) {
			playerLocation.y -= 5;
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT) && playerLocation.x < (MyGdxGame.screenWidth - playerTexture.getWidth() - 5)) {
			playerLocation.x += 5;
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT) && playerLocation.x > 5) {
			playerLocation.x -= 5;
		}
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)){
			isWarningOn = false;
		}
		
		if (Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.DOWN)
			|| Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.RIGHT)
			|| Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			isWrongInput = false;
		} else {
			isWrongInput = true;
		}
		bulletManager.update();
		enemyManager.update(level);
		collisionHandler.update();
		if (++delayTime == 500) {
			level++;
			delayTime = 0;
		}
		playerBounds.setPosition(playerLocation);
		scoreLayout.setText(scoreText, "Score: " + String.valueOf(score));
		if (health <= 0) {
			MyGdxGame.state = State.GAMEOVER;
		}
		
	}
	
	public void render() {
		
		
		for (int  i = 0; i < health; i++) {
			MyGdxGame.batch.draw(healthTexture, 10 + i*20, 5);
		}
		if (isWarningOn == true) {
			if (isWrongInput == true) {
				wrongInputWarning.draw(MyGdxGame.batch, wrongInputWarningLayout,
						MyGdxGame.screenWidth / 2 - wrongInputWarningLayout.width / 2,
						MyGdxGame.screenHeight / 2 + wrongInputWarningLayout.height / 2);
			}
		}
		bulletManager.render();
		enemyManager.render();
		MyGdxGame.batch.draw(playerTexture, playerLocation.x, playerLocation.y);
		scoreText.draw(MyGdxGame.batch,scoreLayout,MyGdxGame.screenWidth - scoreLayout.width - 5, 25);
	}
	
}
