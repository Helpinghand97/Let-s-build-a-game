package game;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static float HEALTH = 100;
	
	private float greenValue = 255;
	
	private int level = 1;
	private int score = 0;
	public void tick(){
		HEALTH = Game.clamp(HEALTH, 0, 100);
		
		greenValue = Game.clamp(greenValue, 0, 255);
		greenValue = HEALTH;
		
		score++;
	}
	
	public void render(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 15);
		g.setColor(new Color(25,(int) greenValue, 0));
		g.fillRect(15, 15,(int) HEALTH * 2, 15);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 15);
		
		g.drawString("Score:" + score, 10, 40);
		g.drawString("Level:" + level, 10, 50);
	}
	
	public void score(int score){
		this.score = score;
	}
	
	public int getScore(){
		return score;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
}
