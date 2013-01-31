package menus;

import maps.*;

import misc.Button;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class PlayMenu extends BasicGameState{
	
	public static int ID;
	private Map maps[], selectedMap;
	private Button mapButtons[];
	
	public PlayMenu(int ID){
		this.ID = ID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
		maps = new Map[1];
		maps[0] = new TestMap("graphics/maps/test.tmx");
		
		mapButtons = new Button[1];
		mapButtons[0] = new Button(new Image("graphics/maps/thumbnails/test_thumbnail.png"), gc);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		
		g.drawString("Selected Map: ", 100, 20); try{
			g.drawString(selectedMap.getName(), 250, 20);
		}catch(Exception e){System.out.println("No map selected!");}
		g.drawString("P1 Character: ", 400, 20);
		g.drawString("P2 Character: ", 600, 20);
		g.scale(0.5f, 0.5f);
		for(int i = 0; i < mapButtons.length; i++){
			mapButtons[i].getGraphics().draw(100 + i*100, 100 + i*100);
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		for(int i = 0; i < mapButtons.length; i++){
			if(mapButtons[i].isClicked()){
				selectedMap = maps[i];
			}
		}
		
	}
	
	public int getID(){
		return ID;
	}
}
