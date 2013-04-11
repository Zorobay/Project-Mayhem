package menus;

import misc.Button;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class GameOverMenu extends BasicGameState{

	public static int ID;
	
	Button rematch, menu;
	Image img;
		
	public GameOverMenu(int ID){
		this.ID = ID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		img = new Image("graphics/buttons/GameOver.png");
		rematch = new Button(img.getSubImage(0, 0, 84, 24), img.getSubImage(0, 24, 84, 24), Button.LEFTBOT(), 0, Button.LEFTBOT(), 0, gc);
		menu = new Button(img.getSubImage(0, 48, 149, 24), img.getSubImage(0, 72, 149, 24), Button.RIGHTBOT(), 0, Button.RIGHTBOT(), 0, gc);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		rematch.getGraphics().draw(rematch.getX(), rematch.getY());
		menu.getGraphics().draw(menu.getX(), menu.getY());
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		
		if(rematch.isClicked()){
			
		}
	}
	
	public int getID(){
		return ID;
	}
}


