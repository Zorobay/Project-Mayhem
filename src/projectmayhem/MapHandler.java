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
	private float charX, charY, yVelocity, delta;
	private boolean isJumping, isOnGround, showStats;
	private Block collisionBlock;
	
	private final float HORISONTAL_VELOCITY = 0.25f;
	private final float VERTICAL_STARTING_VELOCITY = 1.5f;
	private final float VERTICAL_GRAVITY = 0.007f;
	
	public MapHandler(int ID){
		this.ID = ID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		map = new TestMap("graphics/maps/test.tmx");
		
		left = new SpriteSheet("graphics/characters/moveleft.png", 32, 64);
		right = new SpriteSheet("graphics/characters/moveright.png", 32, 64);
		
		moveLeft = new Animation(left, 200);
		moveRight = new Animation(right, 200);
		character = moveRight;
		character.setAutoUpdate(true);
		
		isJumping = false;
		showStats = true;
		
<<<<<<< HEAD
		// SET STABLE FRAMERATE
		gc.setTargetFrameRate(60);
		//-------------------------

=======
>>>>>>> ca9d94c0ed41f336e4517ed743c9b196c603babe
		// DEFINE PLAYER POLY
		playerPoly = new Polygon(new float[]
		{charX, charY, 
		charX + 32,charY,
		charX + 32, charY + 64, 
		charX, charY + 64});
		//--------------------------
		
		charX = 600; charY = 576-64-32;
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// RENDER CHARACTER AND MAP
		TestMap.testMap.render(0, 0);
		character.draw(charX, charY);
		//-------------------------
		
		// RENDER OPTIONAL STATS
		g.setColor(Color.magenta);
		if(showStats){
			g.draw(playerPoly);
			g.drawString("CharX: " + String.format("%.3f", charX) + " CharY: " + String.format("%.3f", charY), 0, 30);
			g.drawString("entityCollision: " + entityCollision(), 0, 50);
			g.drawString("yVelocity: " + yVelocity, 0, 70);
			g.drawString("isJumping: " + isJumping, 0, 90);
			g.drawString("isOnGround: " + isOnGround, 0, 110);
			g.drawString("playerPoly Y: " + playerPoly.getY(), 0, 130);
			g.drawString("delta: "  + this.delta, 0, 150);
			
			for(int i = 0; i < TestMap.blocks.size(); i++){
				Block b = (Block)TestMap.blocks.get(i);
				g.draw(b.blockPoly);
			}
		}
		//----------------------
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		this.delta = delta;
		Input input = gc.getInput();
		
		// TOGGLE STATS
		if(input.isKeyPressed(Input.KEY_S)){
			if(showStats){
				showStats = false;
			}
			else{
				showStats = true;
			}
		}
		//-------------------------------
		
		// MOVE THE CHARACTER RIGHT
		if(input.isKeyDown(Input.KEY_RIGHT)){
			character = moveRight;
			charX += HORISONTAL_VELOCITY*delta;
			playerPoly.setX(charX);
			if(entityCollision()){
				charX -= HORISONTAL_VELOCITY*delta;
				playerPoly.setX(charX);
			}
		}
		//--------------------------------
		
		// MOVE THE CHARACTER LEFT
		if(input.isKeyDown(Input.KEY_LEFT)){
			character = moveLeft;
			charX -= HORISONTAL_VELOCITY*delta;
			playerPoly.setX(charX);
			if(entityCollision()){
				charX += HORISONTAL_VELOCITY*delta;
				playerPoly.setX(charX);
			}
		}
		//--------------------------------
		
		// START JUMPING
		if(input.isKeyPressed(Input.KEY_UP) && isJumping == false){ //you can jump as long as you're not airborne
			isJumping = true;
			//isOnGround = false;
<<<<<<< HEAD
			yVelocity = VERTICAL_STARTING_VELOCITY;
=======
			yVelocity = 2.0f;
>>>>>>> ca9d94c0ed41f336e4517ed743c9b196c603babe
		}
		// STARTS THE JUMP LOOP
		if(isJumping){
			yVelocity -= VERTICAL_GRAVITY*delta;
			charY -= yVelocity*delta;
			playerPoly.setY(charY);
			if(entityCollision()){
				if(yVelocity > 0){//if the player is rising
					charY = collisionBlock.blockPoly.getMaxY();
				}
				else{
					charY = collisionBlock.blockPoly.getMinY() - (playerPoly.getHeight()+1);
					isJumping = false;
					//isOnGround = true;
				}
				yVelocity = 0;
				playerPoly.setY(charY);
			}
		}
		//---------------------------
		
		// CHECKS IF THE CHARACTER IS ON THE GROUND
		playerPoly.setY(charY + 1); //check if player is only 1 pixel above ground
		if(entityCollision()){
			//isOnGround = true;
			isJumping = false;
			yVelocity = 0;
			charY = collisionBlock.blockPoly.getMinY() - (playerPoly.getHeight()+1);
			playerPoly.setY(charY);
		} // IF NOT, ACCELERATE DOWNWARD
		else if(isJumping == false){ 
<<<<<<< HEAD
			yVelocity += VERTICAL_GRAVITY*delta;
=======
			yVelocity += 0.01f*delta;
>>>>>>> ca9d94c0ed41f336e4517ed743c9b196c603babe
			charY += yVelocity*delta;
			playerPoly.setY(charY);
		}
		//---------------------------------
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
