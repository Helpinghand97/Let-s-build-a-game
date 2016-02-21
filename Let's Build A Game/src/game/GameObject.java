package game;

import java.awt.Graphics;
import java.awt.Rectangle;

//To tell the game that anything that is extending GameObject is either an enemy or a player
public abstract class GameObject {
	
	protected float x,y;
	protected ID id;
	protected float velX, velY;
	Handler handler;
	
	//Classifying the object where it is and what it is
	public GameObject(float x, float y, ID id, Handler handler){
		this.x = x;
		this.y = y;
		this.id = id;
		this.handler = handler;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	//Setting the variables
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setvelX(int velX){
		this.velX = velX;
	}
	
	public void setvelY(int velY){
		this.velY = velY;
	}
	
	public void setId(ID id){
		this.id = id;
	}
	
	//Gets the variables
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getvelX(){
		return velX;
	}
	
	public float getvelY(){
		return velY;
	}
	
	public ID getId(){
		return id;
	}
}
