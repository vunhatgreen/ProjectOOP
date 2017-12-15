package framework;

import java.util.ArrayList;

import com.mygdx.game.MyGdxGame;

import object.Enemy;
import object.EnemyBoss;

public class EnemyManager {
	protected ArrayList<Enemy> enemyManager = new ArrayList<Enemy>();
	public ArrayList<EnemyBoss> enemyBossManager = new ArrayList<EnemyBoss>();
	private int delayTime = 0;
	private int numberOfEnemy;
	public boolean isBossDead = false;
	
	public void update(int level) {
		try {
		delayTime++;
		if (level < 10) {
			numberOfEnemy = level;
		} else {
			numberOfEnemy = 10;
		}
		if (delayTime == 200) {
			for (int i = 0; i < numberOfEnemy; i++) {
				enemyManager.add(new Enemy());
			}
			delayTime = 0;
		}
		if (level % 5 == 0) {
			enemyBossManager.add(new EnemyBoss());
		}
		} catch (NullPointerException nullPointer) {
			nullPointer.printStackTrace();
		}
	}
	
	public void render() {
		try {
		for (int i = 0; i < enemyManager.size(); i++) {
			Enemy currentEnemy = enemyManager.get(i);
			if (currentEnemy.getEnemyLocation().y > -100 && currentEnemy.getEnemyLocation().y < MyGdxGame.screenHeight + 101) {
				currentEnemy.update();
				currentEnemy.render();
			} else {
				enemyManager.remove(i);
			}
		}
		if (isBossDead == false) {
			enemyBossManager.get(0).render();
		} else {
			enemyBossManager.remove(0);
		}
		} catch (NullPointerException nullPointer) {
			nullPointer.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
}
