package projectmayhem;

import misc.Button;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState {

	public static int ID;

	Button play, settings;

	public MainMenu(int ID) {
		this.ID = ID;
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		play = new Button(new Image("graphics/buttons/textplaybutton.png"),
				new Image("graphics/buttons/textplaybuttonhover.png"),
				Button.MID(), Button.MID(), gc);
		settings = new Button(new Image(
				"graphics/buttons/textsettingsbutton.png"), new Image(
				"graphics/buttons/textsettingsbuttonhover.png"), Button.MID(),
				0, Button.MID(), 90, gc);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		play.getGraphics().draw(play.getX(), play.getY());
		settings.getGraphics().draw(settings.getX(), settings.getY());
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (settings.isClicked()) {
			sbg.enterState(1);
		}
		
		if(play.isClicked()){
			sbg.enterState(2);
		}
	}

	public int getID() {
		return ID;
	}

}
