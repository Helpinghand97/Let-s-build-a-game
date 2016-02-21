package game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	//Gets the tick of the Object
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	//Renders the Object
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	//Adds the Object
	public void addObject(GameObject object){
		this.object.add(object);
	}
	//Removes the Object
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	public void clearEnemy(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			if(tempObject.getId() != ID.Player) removeObject(tempObject);
		}
	}
}
