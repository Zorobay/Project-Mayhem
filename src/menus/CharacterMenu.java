package menus;

import maps.*;

import misc.Button;
import playablecharacters.Tails;
import playablecharacters.Character;
import projectmayhem.MapHandler;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class CharacterMenu extends BasicGameState{
	
	public static int ID;
	private Button mapButtons[], characterButton[];
	private Button buttonBack, buttonContinue;
	private Image img;

	private static Character p1Character;
	private static Character p2Character;
	private Character characters[];
	
	public CharacterMenu(int ID){
		this.ID = ID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
		characters = new Character[1];
		characters[0] = new Tails();
		
		characterButton = new Button[1];
		characterButton[0] = new Button(new Image("graphics/characters/thumbnails/fatrobot.png"), null, new Image("graphics/characters/thumbnails/fatrobot_selected.png"), gc);
		
		buttonBack = new Button(new Image("graphics/buttons/playmenu.png").getSubImage(0, 0, 86, 25), new Image("graphics/buttons/playmenu.png").getSubImage(0, 25, 86, 25), 20, 500, gc);
		buttonContinue = new Button(new Image("graphics/buttons/playmenu.png").getSubImage(0, 50, 153, 24), new Image("graphics/buttons/playmenu.png").getSubImage(0, 74, 153, 24), 600, 500, gc);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		
		if(characterButton[0].getPoly() != null){
			g.draw(characterButton[0].getPoly());
		}
		
		g.drawString("Selected Map: ", 100, 20); //What map did the user select?
		g.drawString(MapMenu.getSelectedMap().getName(), 250, 20);
		
		g.drawString("P1 Character: ", 500, 20); //Who did player 1 choose?
		if(p1Character != null){
			g.drawString(p1Character.getName(), 650, 20);
		}
		
		g.drawString("P2 Character: ", 900, 20); //Who did player 2 choose?
		if(p2Character != null){
			g.drawString(p2Character.getName(), 1050, 20);
		}
		
		buttonBack.getGraphics().draw(buttonBack.getX(), buttonBack.getY());
		buttonContinue.getGraphics().draw(buttonContinue.getX(), buttonContinue.getY());
		
		for(int i = 0; i < characterButton.length; i++){
			characterButton[i].setX(100 + i*100);
			characterButton[i].setY(100 + i*100);
			characterButton[i].getGraphics().draw(100 + i*100, 100 + i*100);
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	
		for(int i = 0; i < characterButton.length; i++){
			if(characterButton[i].isClicked()){
				System.out.println("Character button clicked!");
				if(p1Character == null){
					p1Character = characters[i];
				}
				else{
					p2Character = characters[i];
				}
			}
		}
		
		if(buttonBack.isClicked()){
			sbg.enterState(0);
		}
		if(buttonContinue.isClicked()){
			if(p1Character != null & p2Character != null){
				sbg.enterState(4);
			}
		}
	}
	
	public static Character getSelectedCharacterP1(){
		return p1Character;
	}
	public static Character getSelectedCharacterP2(){
		return p2Character;
	}
	public int getID(){
		return ID;
	}
}
