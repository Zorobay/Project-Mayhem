package projectmayhem;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class ProjectMayhem extends StateBasedGame{
	
	static AppGameContainer appgc;
	private static final String TITLE = "Project Mayhem! v0.1";
	
	//Declare all state IDs
	public static final int MAINMENU = 0;
	
	
	public ProjectMayhem(String name) {
		super(name);
		this.addState(new MainMenu(MAINMENU));
		
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MAINMENU).init(gc, this);
		this.enterState(MAINMENU);
	}
	
	public static void main (String args[]) throws SlickException{
		appgc = new AppGameContainer(new ScalableGame(new ProjectMayhem(TITLE), 1024, 600, false));
		appgc.setDisplayMode(1024, 600, false);
		appgc.start();
	}
	
	public static void setResolution(int x, int y, boolean fullscreen) throws SlickException{
		appgc.setDisplayMode(x, y, fullscreen);
	}
}
		
	