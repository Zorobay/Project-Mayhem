package menus;

import maps.*;

import misc.Button;
import playablecharacters.TestCharacter;
import playablecharacters.Character;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class MapMenu extends BasicGameState{
	
	public static int ID;
	private Map maps[], selectedMap;
	private Button mapButton[];
	private Button buttonBack, buttonContinue;

	private Character p1Character, p2Character, characters[];
	
	public MapMenu(int ID){
		this.ID = ID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		maps = new Map[1];
		maps[0] = new TestMap("graphics/maps/test.tmx");
				
		mapButton = new Button[1];
		mapButton[0] = new Button(new Image("graphics/maps/thumbnails/test_thumbnail.png"), null, new Image("graphics/maps/thumbnails/test_thumbnail_selected.png"), gc);
		
		buttonBack = new Button(new Image("graphics/buttons/playmenu.png").getSubImage(0, 0, 86, 25), new Image("graphics/buttons/playmenu.png").getSubImage(0, 25, 86, 25), 20, 500, gc);
		buttonContinue = new Button(new Image("graphics/buttons/playmenu.png").getSubImage(0, 50, 153, 24), new Image("graphics/buttons/playmenu.png").getSubImage(0, 74, 153, 24), 600, 500, gc);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		
		
		g.drawString("Selected Map: ", 100, 20); //What map did the user select?
		if(selectedMap != null){
			g.drawString(selectedMap.getName(), 250, 20);
		}
		g.drawString("P1 Character: ", 400, 20); //Who did player 1 choose?
		g.drawString("P2 Character: ", 600, 20); //Who did player 2 choose?
		
		buttonBack.getGraphics().draw(buttonBack.getX(), buttonBack.getY());
		buttonContinue.getGraphics().draw(buttonContinue.getX(), buttonContinue.getY());
		
		g.scale(0.5f, 0.5f);
		for(int i = 0; i < mapButton.length; i++){
			g.draw(mapButton[i].getPoly());
			mapButton[i].setScale(0.5f, 0.5f);
			mapButton[i].setX(100 + i*100);
			mapButton[i].setY(100 + i*100);
			mapButton[i].getGraphics().draw(100 + i*100, 100 + i*100);
		}
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		for(int i = 0; i < mapButton.length; i++){
			if(mapButton[i].isClicked()){
				System.out.println("Map button clicked!");
				selectedMap = maps[i];
			}
		}
		
		if(buttonBack.isClicked()){
			sbg.enterState(0);
		}
		if(buttonContinue.isClicked() && selectedMap != null){
			sbg.enterState(3);
		}
	}
	
	public int getID(){
		return ID;
	}
}
