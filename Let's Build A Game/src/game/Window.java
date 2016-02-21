package game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = -4369730830015653927L;
	
	//This gets the size of the window for the game
	public Window(int width, int height, String title, Game game){
		//The Frame of the Window
		JFrame frame = new JFrame(title);
		
		//Setting the size of the Window
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		
		//All the fancy stuff for the window frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.add(game);
		
		//Starting the game in the Game Class
		game.start();
		
	}
}
