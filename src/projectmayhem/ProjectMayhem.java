package projectmayhem;

import java.awt.Dimension;
import java.awt.Toolkit;

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
	private static final int SETTINGS = 1;
	private static final int PLAY = 2;

	public ProjectMayhem(String name) {
		super(name);
		this.addState(new MainMenu(MAINMENU));
		this.addState(new Settings(SETTINGS));
		this.addState(new Play(PLAY));
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MAINMENU).init(gc, this);
		this.getState(SETTINGS).init(gc, this);
		this.getState(PLAY).init(gc, this);
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
