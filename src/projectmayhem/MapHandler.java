package projectmayhem;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.particles.Particle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class MapHandler extends BasicGameState{
	
	private static int ID;
	public TestMap map;
	private SpriteSheet left, right, partic;
	private Animation moveLeft, moveRight, character;
	private Polygon playerPoly;
	private float charX, charY, yVelocity;
	private boolean isJumping, collision, isOnGround;
	private Block collisionBlock;
	
	public MapHandler(int ID){
		this.ID = ID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		charX = 600; charY = 576-64-38;
			
		map = new TestMap("graphics/maps/test.tmx");
		
		left = new SpriteSheet("graphics/characters/moveleft.png", 32, 64);
		right = new SpriteSheet("graphics/characters/moveright.png", 32, 64);
		
		moveLeft = new Animation(left, 200);
		moveRight = new Animation(right, 200);
		character = moveRight;
		character.setAutoUpdate(true);
		
		collision = false;
		isJumping = false;
		
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
		g.drawString("CharX: " + String.format("%.3f", charX) + " CharY: " + String.format("%.3f", charY), 0, 30);
		g.drawString("entityCollision: " + entityCollision(), 0, 50);
		g.drawString("yVelocity: " + yVelocity, 0, 70);
		g.drawString("isJumping: " + isJumping, 0, 90);
		g.drawString("isOnGround: " + isOnGround, 0, 110);
		g.drawString("playerPoly Y: " + playerPoly.getY(), 0, 130);
		
		for(int i = 0; i < TestMap.blocks.size(); i++){
			Block b = (Block)TestMap.blocks.get(i);
			g.draw(b.blockPoly);

		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			character = moveRight;
			charX += 0.2f*delta;
			playerPoly.setX(charX);
			if(entityCollision()){
				charX -= 0.2f*delta;
				playerPoly.setX(charX);
			}
			
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			character = moveLeft;
			charX -= 0.2f*delta;
			playerPoly.setX(charX);
			if(entityCollision()){
				charX += 0.2f*delta;
				playerPoly.setX(charX);
			}
			
		}
		
		if(input.isKeyPressed(Input.KEY_UP) && isJumping == false){ //you can jump as long as you're not airborne
			isJumping = true;
			isOnGround = false;
			yVelocity = 2.0f;
		}
		if(isJumping){
			yVelocity -= 0.01f;
			charY -= yVelocity*delta;
			playerPoly.setY(charY);
			if(entityCollision()){
				if(yVelocity > 0){//if the player is rising
					charY = collisionBlock.blockPoly.getMaxY();
				}
				else{
					charY = collisionBlock.blockPoly.getMinY() - 65;
					isJumping = false;
					isOnGround = true;
				}
				yVelocity = 0;
				playerPoly.setY(charY);
			}
		}
		
		playerPoly.setY(charY + 1); //check if player is only 1 pixel above ground
		if(entityCollision()){
			isOnGround = true;
			charY = collisionBlock.blockPoly.getMinY() -65;
			playerPoly.setY(charY);
		}
		else if(isJumping == false){ //if not, then accelerate player downwards
			yVelocity += 0.01f;
			charY += yVelocity*delta;
			playerPoly.setY(charY);
		}
	}
	
	
	public boolean entityCollision() throws SlickException{
		for(int i = 0; i < TestMap.blocks.size(); i++){
			Block entity = (Block)TestMap.blocks.get(i);
			if(playerPoly.intersects(entity.blockPoly)){
				collisionBlock = (Block)TestMap.blocks.get(i);
				return true;
			}
		}
		return false;
	}
		
	public int getID() {
		return ID;
	}

}
