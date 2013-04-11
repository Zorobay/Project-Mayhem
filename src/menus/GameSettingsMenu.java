package menus;

import misc.Button;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import projectmayhem.MapHandler;
import projectmayhem.ProjectMayhem;


public class GameSettingsMenu extends BasicGameState{

	public static int ID;
	private Image gsm;
	private Button one, two;
	private static int deaths;
	
	public GameSettingsMenu(int ID){
		this.ID = ID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	
		gsm = new Image("graphics/buttons/gamesettingsmenu.png");
		
		one = new Button(gsm.getSubImage(0, 0, 9, 25), gsm.getSubImage(0, 25, 9, 25), Button.MID(), Button.MID(), gc);
		two = new Button(gsm.getSubImage(0, 50, 22, 24), gsm.getSubImage(0, 74, 22, 24), Button.MID(),0, Button.MID(), 100, gc);
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawString("Choose max number of deaths before game ends", gc.getWidth()/2 - 200, 200);
		
		g.drawImage(one.getGraphics(), one.getX(), one.getY());
		g.drawImage(two.getGraphics(), two.getX(), two.getY());
	
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{

		if(one.isClicked()){
			deaths = 1;
			sbg.enterState(5);
		}
		if(two.isClicked()){
			deaths = 2;
			sbg.enterState(5);
		}
		
	}
	
	public static int getDeaths(){
		return deaths;
	}
	
	public int getID(){
		return ID;
	}
}
