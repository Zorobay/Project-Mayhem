package projectmayhem;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Test extends BasicGameState{
	
	private static int ID;
	private TiledMap map;
	private SpriteSheet left, right;
	private Animation moveLeft, moveRight, character;
	private float charX, charY, jump[];
	private boolean platform[][];
	private boolean isAirborn;
	
	public Test(int ID){
		this.ID = ID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		charX = 600; charY = 576-64-32;
			
		map = new TiledMap("graphics/maps/test.tmx");
		
		left = new SpriteSheet("graphics/characters/moveleft.png", 32, 64);
		right = new SpriteSheet("graphics/characters/moveright.png", 32, 64);
		
		moveLeft = new Animation(left, 200);
		moveRight = new Animation(right, 200);
		character = moveRight;
		
		jump = new float[960];
		float dist = 0.3f;
		float add = 0;
		for(int i = 0; i<= 959; i++){
			jump[i] = dist; 
			dist += 0.3 - add;
			add += 0.005;
		}
		platform = new boolean[map.getWidth()][map.getHeight()];
		isAirborn = false;
		
		for(int x = 0; x < map.getWidth(); x++){
			for(int y = 0; y < map.getHeight(); y++){
				int tiledID = map.getTileId(x, y, 0);
				String value = map.getTileProperty(tiledID, "platform", "false");
				if("true".equals(value)){
					platform[x][y] = true;
					System.out.println("added value: " + platform[x][y] + " to location: " + x + " "+ y);
				}
			}
		}
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		map.render(0, 0);
		character.draw(charX, charY);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		
		if(!isPlatform(charX, charY) || isPlatform(charX + 32, charY-1)){ //anti gravity
			charY += 0.2f*delta;
		}
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			character = moveRight;
			charX += 0.1f*delta;
			if(isPlatform(charX + 32, charY-1)){
				charX -= 0.1f*delta;
			}
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			character = moveLeft;
			charX -= 0.1f*delta;
			if(isPlatform(charX, charY-1)){
				charX += 0.1f*delta;
			}
		}
		if(input.isKeyPressed(Input.KEY_UP)){
			isAirborn = true;
			float currentY = charY;
			
			for(int i = 0; i <= 959; i++){
				charY -= jump[i];
			}
			
			//while(charY >= currentY - 96f){
				//charY -= 0.0000002f*delta;
			//}
		}
		
	}

	public int getID() {
		return ID;
	}
	
	private boolean isPlatform(float x, float y){
		return platform[((int)x)/32][((int)y + 64)/32];
	}

}
