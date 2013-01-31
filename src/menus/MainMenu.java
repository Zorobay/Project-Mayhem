package menus;

import misc.Button;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState {

	public static int ID;
	
	Image mainmenubuttons;
	Button play, settings, exit;

	public MainMenu(int ID) {
		this.ID = ID;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		mainmenubuttons = new Image("graphics/buttons/mainmenu.png");
		
		play = new Button(mainmenubuttons.getSubImage(0, 0, 106, 31),
				mainmenubuttons.getSubImage(0, 31, 105, 31),
				Button.MID(), Button.MID(), gc);
		settings = new Button(mainmenubuttons.getSubImage(0, 62, 192, 31), 
				mainmenubuttons.getSubImage(0, 93, 192, 31), Button.MID(),
				0, Button.MID(), 90, gc);
		exit = new Button(mainmenubuttons.getSubImage(0, 124, 83, 31), 
				mainmenubuttons.getSubImage(0, 155, 83, 31), Button.MID(),
				0, Button.MID(), 180, gc);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		play.getGraphics().draw(play.getX(), play.getY());
		settings.getGraphics().draw(settings.getX(), settings.getY());
		exit.getGraphics().draw(exit.getX(),exit.getY());
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (settings.isClicked()) {
			sbg.enterState(1);
		}
		
		if(play.isClicked()){
			sbg.enterState(2);
		}
		if(exit.isClicked()){
			gc.exit();
		}
	}

	public int getID() {
		return ID;
	}

}
