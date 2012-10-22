package projectmayhem;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Test extends BasicGameState{
	
	private static int ID;
	public TestMap map;
	private SpriteSheet left, right;
	private Animation moveLeft, moveRight, character;
	private Polygon playerPoly;
	private float charX, charY, acceleration;
	private boolean platform[][];
	private boolean isAirborn, collision;
	
	public Test(int ID){
		this.ID = ID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		charX = 600; charY = 576-64-32;
			
		map = new TestMap("graphics/maps/test.tmx");
		
		left = new SpriteSheet("graphics/characters/moveleft.png", 32, 64);
		right = new SpriteSheet("graphics/characters/moveright.png", 32, 64);
		
		moveLeft = new Animation(left, 200);
		moveRight = new Animation(right, 200);
		character = moveRight;
		character.setAutoUpdate(true);
		
		collision = false;
		isAirborn = false;
		
		playerPoly = new Polygon(new float[]
		{charX, charY, 
		charX + 32,charY,
		charX + 32, charY + 64, 
		charX, charY + 64});
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		TestMap.testMap.render(0, 0);
		character.draw(charX, charY);
		
		g.setColor(Color.magenta);
		g.draw(playerPoly);
		g.drawString("CharX: " + String.format("%.3f", charX) + " CharY: " + String.format("%.3f", charY), 400, 20);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			character = moveRight;
			charX += 0.1f*delta;
			playerPoly.setX(charX);
			if(entityCollision()){
				charX -= 0.1f*delta;
				playerPoly.setX(charX);
			}
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			character = moveLeft;
			charX -= 0.1f*delta;
			playerPoly.setX(charX);
			if(entityCollision()){
				charX += 0.1f*delta;
				playerPoly.setX(charX);
			}
		}
		if(input.isKeyDown(Input.KEY_UP)){
			charY -= 0.1f*delta;
			playerPoly.setY(charY);
			if(entityCollision()){
				charY += 0.1f*delta;
				playerPoly.setY(charY);
			}
		}
		if(input.isKeyDown(Input.KEY_DOWN)){
			charY += 0.1f*delta;
			playerPoly.setY(charY);
			if(entityCollision()){
				charY -= 0.1f*delta;
				playerPoly.setY(charY);
			}
		}
		
	}
	public boolean entityCollision() throws SlickException{
		for(int i = 0; i < TestMap.blocks.size(); i++){
			Block entity = (Block)TestMap.blocks.get(i);
			if(playerPoly.intersects(entity.blockPoly)){
				return true;
			}
		}
		return false;
	}
	
	public int getID() {
		return ID;
	}

}
