package game;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random ran = new Random();
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick(){
		scoreKeep++;
		
		if(scoreKeep>= 100){
			scoreKeep = 0;
			hud.setLevel(hud.getLevel()+ 1);
			
			if(hud.getLevel()==2){
				handler.addObject(new BasicEnemy(ran.nextInt(Game.WIDTH),ran.nextInt(Game.HEIGHT),ID.Enemy,handler));
				handler.addObject(new FastEnemy(ran.nextInt(Game.WIDTH), ran.nextInt(Game.HEIGHT), ID.Enemy, handler));

			}
			else if(hud.getLevel() == 3){
				handler.addObject(new SmartEnemy(ran.nextInt(Game.WIDTH),ran.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
			}
			
			else if(hud.getLevel() == 10){
				handler.clearEnemy();
				handler.addObject(new EnemyBoss(ran.nextInt(Game.HEIGHT/2)+ 96, -128, ID.EnemyBoss, handler));
			}
		}
	}
}
