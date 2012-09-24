package projectmayhem;

import misc.Button;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Settings extends BasicGameState{

	public static int ID; 

	Button fullscreen;
	Button windowed;
	Button resolution;
	
	public Settings(int ID){
		this.ID = ID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		fullscreen = new Button(new Image("graphics/buttons/playbutton.png"), new Image("graphics/buttons/playbuttonhover.png"), Button.MID(),0, Button.MID(),-75, gc);
		windowed = new Button(new Image("graphics/buttons/playbutton.png"), new Image("graphics/buttons/playbuttonhover.png"), Button.MID(), Button.MID(), gc);
		resolution = new Button(new Image("graphics/buttons/playbutton.png"), new Image("graphics/buttons/playbuttonhover.png"), Button.MID(),0, Button.MID(),75, gc);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		fullscreen.getGraphics().draw(fullscreen.getX(), fullscreen.getY());
		windowed.getGraphics().draw(windowed.getX(), windowed.getY());
		resolution.getGraphics().draw(resolution.getX(), resolution.getY());
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	
		
	}
	
	public int getID(){
		return ID;
	}
}
