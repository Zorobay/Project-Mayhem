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
	
	Image settingsmenu;
	Button fullscreenon, fullscreenoff;
	Button windowed;
	Button resolution;
	
	public Settings(int ID){
		this.ID = ID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		settingsmenu = new Image("graphics/buttons/settingsmenu.png");
		
		fullscreenon = new Button(settingsmenu.getSubImage(0, 0, 232, 28), settingsmenu.getSubImage(0, 28, 232, 28), Button.MID(), Button.MID(), gc);
		fullscreenoff = new Button(settingsmenu.getSubImage(0, 56, 246, 28), settingsmenu.getSubImage(0, 84, 246, 28), Button.MID(), Button.MID(), gc);
		//windowed = new Button(new Image("graphics/buttons/playbutton.png"), new Image("graphics/buttons/playbuttonhover.png"), Button.MID(), Button.MID(), gc);
		//resolution = new Button(new Image("graphics/buttons/playbutton.png"), new Image("graphics/buttons/playbuttonhover.png"), Button.MID(),0, Button.MID(),75, gc);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		if(gc.isFullscreen()){
			fullscreenon.getGraphics().draw(fullscreenon.getX(), fullscreenon.getY());
		}
		else{
			fullscreenoff.getGraphics().draw(fullscreenoff.getX(), fullscreenoff.getY());
		}
		
		//windowed.getGraphics().draw(windowed.getX(), windowed.getY());
		//resolution.getGraphics().draw(resolution.getX(), resolution.getY());
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		if(fullscreenon.isClicked()){
			gc.setFullscreen(false);
		}
		if(fullscreenoff.isClicked()){
			gc.setFullscreen(true);
		}
	}
	
	public int getID(){
		return ID;
	}
}
