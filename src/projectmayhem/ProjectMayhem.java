package projectmayhem;

import java.awt.Dimension;
import java.awt.Toolkit;

import menus.*;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ProjectMayhem extends StateBasedGame {

	static AppGameContainer appgc;
	static int xres;
	static int yres;
	static boolean isFullscreen;
	private static final String TITLE = "Project Mayhem! v0.1";
	
	// Declare all state IDs
	private static final int MAINMENU = 0;
	private static final int SETTINGSMENU = 1;
	private static final int MAPMENU = 2;
	private static final int CHARMENU = 3;
	private static final int GSETTINGSMENU = 4;
	private static final int MAPHANDLER = 5;
	private static final int GAMEOVERMENU = 6;

	public ProjectMayhem(String name) {
		super(name);
		this.addState(new MainMenu(MAINMENU));
		this.addState(new SettingsMenu(SETTINGSMENU));
		this.addState(new MapMenu(MAPMENU));
		this.addState(new CharacterMenu(CHARMENU));
		this.addState(new GameSettingsMenu(GSETTINGSMENU));
		this.addState(new MapHandler(MAPHANDLER));
		this.addState(new GameOverMenu(GAMEOVERMENU));
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MAINMENU).init(gc, this);
		this.getState(SETTINGSMENU).init(gc, this);
		this.getState(MAPMENU).init(gc, this);
		this.getState(CHARMENU).init(gc, this);
		this.getState(GSETTINGSMENU).init(gc, this);
		//this.getState(MAPHANDLER).init(gc, this);
		this.getState(GAMEOVERMENU).init(gc, this);
		this.enterState(MAINMENU);
	}

	public static void main(String args[]) throws SlickException {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //To get the default resolution of the monitor
		
		xres = (int) dim.getWidth();
		yres = (int) dim.getHeight();
		appgc = new AppGameContainer(new ScalableGame(new ProjectMayhem(TITLE),
				xres, yres, false));
		appgc.setDisplayMode(xres, yres, false);
		appgc.start();
	}

	public static void setResolution(int x, int y)
			throws SlickException {
		xres = x;
		yres = y;
		appgc.setDisplayMode(xres, yres, isFullscreen);
	}

	public static void setFullscreen(boolean fullscreen) throws SlickException {
		appgc.setDisplayMode(xres, yres, fullscreen);
	}
}
