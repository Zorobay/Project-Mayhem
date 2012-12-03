package projectmayhem;

import java.io.IOException;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
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
	private float delta;
	private boolean showStats;
	private Block collisionBlock;
	private Player player1,  player2;
	
	private final float HORISONTAL_VELOCITY = 0.25f;
	private final float VERTICAL_STARTING_VELOCITY = 1.5f;
	private final float VERTICAL_GRAVITY = 0.007f;
	
	public MapHandler(int ID){
		this.ID = ID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		player1 = new Player("Player 1");
		player2 = new Player("Player 2");
		
		map = new TestMap("graphics/maps/test.tmx");
		showStats = true;
		
		//RUN PLAYER METHODS
		player1.setIsJumping(false);
		player2.setIsJumping(false);
		
		player1.setMoveRightKey(Input.KEY_RIGHT);
		player1.setMoveLeftKey(Input.KEY_LEFT);
		player1.setJumpKey(Input.KEY_UP);
		player2.setMoveRightKey(Input.KEY_D);
		player2.setMoveLeftKey(Input.KEY_A);
		player2.setJumpKey(Input.KEY_W);
		
		player1.setMaxHealth(100);
		player1.setCurrentHealth(100);
		player2.setMaxHealth(100);
		player2.setCurrentHealth(100);
		//----------------------------
		
		// SET STABLE FRAMERATE
		gc.setTargetFrameRate(60);
		//-------------------------
		
		player1.setX(600); player1.setY(576-64-32); //TODO This should be independent of player character size
		player2.setX(200); player2.setY(576-64-32);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		// RENDER CHARACTER AND MAP
		TestMap.testMap.render(0, 0);
		player1.getAnimation().draw(player1.getX(), player1.getY());
		player2.getAnimation().draw(player2.getX(), player2.getY());
		//-------------------------
		
		// RENDER OPTIONAL STATS
		g.setColor(Color.magenta);
		if(showStats){
			//RENDER PLAYER 1 STATS
			g.draw(player1.getPolygon());
			g.drawString("Player 1: " + String.format("%.3f", player1.getX()) + " CharY: " + String.format("%.3f", player1.getY()), 0, 30);
			g.drawString("yVelocity: " + player1.getYVelocity(), 0, 50);
			g.drawString("isJumping: " + player1.isJumping(), 0, 70);
			g.drawString("playerPoly Y: " + player1.getPolyY(), 0, 90);
			//----------------------------------
			
			//RENDER PLAYER 2 STATS
			g.draw(player2.getPolygon());
			g.drawString("Player 2: " + String.format("%.3f", player2.getX()) + " CharY: " + String.format("%.3f", player2.getY()), 600, 30);
			g.drawString("yVelocity: " + player2.getYVelocity(), 600, 50);
			g.drawString("isJumping: " + player2.isJumping(), 600, 70);
			g.drawString("playerPoly Y: " + player2.getPolyY(), 600, 90);
			//----------------------------------
			
			//RENDER MISC STATS
			g.drawString("delta: "  + this.delta, 400, 30);
			//----------------------------------
			
			for(int i = 0; i < TestMap.blocks.size(); i++){
				Block b = (Block)TestMap.blocks.get(i);
				g.draw(b.blockPoly);
			}
		}
		//RENDER PLAYER HEALTH
		g.setColor(Color.red);
		g.drawRect(player1.getCenterX() - (25), player1.getY()-12, player1.getCurrentHealth() / 2, 10);
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
		
		// MOVE PLAYER 1 RIGHT
		if(input.isKeyDown(player1.getMoveRightKey())){
			player1.setAnimation(Player.RIGHT);
			player1.setX(player1.getX() + HORISONTAL_VELOCITY*delta);
			player1.setAnimation(Player.RIGHT);
			if(entityCollision(player1.getPolygon())){
				player1.setX(player1.getX() - HORISONTAL_VELOCITY*delta);
			}
		}
		//--------------------------------
		
		// MOVE PLAYER 1 LEFT
		if(input.isKeyDown(player1.getMoveLeftKey())){
			player1.setAnimation(Player.LEFT);
			player1.setX(player1.getX() - HORISONTAL_VELOCITY*delta);
			if(entityCollision(player1.getPolygon())){
			player1.setX(player1.getX() + HORISONTAL_VELOCITY*delta);
			}
		}
		//--------------------------------
		
		// START JUMP FOR PLAYER 1
		if(input.isKeyPressed(Input.KEY_UP) && player1.isJumping() == false){ //you can jump as long as you're not airborne
			player1.setIsJumping(true);
			//isOnGround = false;
			player1.setYVelocity(VERTICAL_STARTING_VELOCITY);
		}
		// STARTS THE JUMP LOOP
		if(player1.isJumping()){
			player1.setYVelocity(player1.getYVelocity() - VERTICAL_GRAVITY*delta);
			player1.setY(player1.getY() - player1.getYVelocity()*delta);
			if(entityCollision(player1.getPolygon())){
				if(player1.getYVelocity() > 0){//if the player is rising
					player1.setY(collisionBlock.blockPoly.getMaxY());
				}
				else{
					player1.setY(collisionBlock.blockPoly.getMinY() - (player1.getPolygon().getHeight()+1));
					player1.setIsJumping(false);
				}
				player1.setYVelocity(0);
			}
		}
		//---------------------------
		
		// CHECKS IF THE CHARACTER IS ON THE GROUND
		player1.setPolyY(player1.getY() + 1); //check if player is only 1 pixel above ground
		if(entityCollision(player1.getPolygon())){
			player1.setIsJumping(false);
			player1.setYVelocity(0);
			player1.setY(collisionBlock.blockPoly.getMinY() - (player1.getPolygon().getHeight()+1));
		} // IF NOT, ACCELERATE DOWNWARD
		else if(player1.isJumping() == false){ 
			player1.setYVelocity(player1.getYVelocity() + VERTICAL_GRAVITY*delta);
			player1.setY(player1.getY() + player1.getYVelocity()*delta);
		}
		//---------------------------------
		
		//MOVE PLAYER 2 RIGHT
		if(input.isKeyDown(player2.getMoveRightKey())){
			player2.setAnimation(Player.RIGHT);
			player2.setX(player2.getX() + HORISONTAL_VELOCITY*delta);
			player2.setAnimation(Player.RIGHT);
			if(entityCollision(player2.getPolygon())){
				player2.setX(player2.getX() - HORISONTAL_VELOCITY*delta);
			}
		}
		//--------------------------------
		
		//MOVE PLAYER 2 LEFT
		if(input.isKeyDown(player2.getMoveLeftKey())){
			player2.setAnimation(Player.LEFT);
			player2.setX(player2.getX() - HORISONTAL_VELOCITY*delta);
			if(entityCollision(player2.getPolygon())){
				player2.setX(player2.getX() + HORISONTAL_VELOCITY*delta);
			}
		}
		//-----------------------------------
		
		// START JUMP FOR PLAYER 2
		if(input.isKeyPressed(player2.getJumpKey()) && player2.isJumping() == false){ //you can jump as long as you're not airborne
			player2.setIsJumping(true);
			//isOnGround = false;
			player2.setYVelocity(VERTICAL_STARTING_VELOCITY);
		}
		// STARTS THE JUMP LOOP
		if(player2.isJumping()){
			player2.setYVelocity(player2.getYVelocity() - VERTICAL_GRAVITY*delta);
			player2.setY(player2.getY() - player2.getYVelocity()*delta);
			if(entityCollision(player2.getPolygon())){
				if(player2.getYVelocity() > 0){//if the player is rising
					player2.setY(collisionBlock.blockPoly.getMaxY());
				}
				else{
					player2.setY(collisionBlock.blockPoly.getMinY() - (player2.getPolygon().getHeight()+1));
					player2.setIsJumping(false);
				}
				player2.setYVelocity(0);
			}
		}
		//---------------------------
		
		// CHECKS IF THE CHARACTER IS ON THE GROUND
		player2.setPolyY(player2.getY() + 1); //check if player is only 1 pixel above ground
		if(entityCollision(player2.getPolygon())){
			player2.setIsJumping(false);
			player2.setYVelocity(0);
			player2.setY(collisionBlock.blockPoly.getMinY() - (player2.getPolygon().getHeight()+1));
		} // IF NOT, ACCELERATE DOWNWARD
		else if(player2.isJumping() == false){ 
			player2.setYVelocity(player2.getYVelocity() + VERTICAL_GRAVITY*delta);
			player2.setY(player2.getY() + player2.getYVelocity()*delta);
		}
		//---------------------------------
		
	}
	
	
	public boolean entityCollision(Polygon object) throws SlickException{
		for(int i = 0; i < TestMap.blocks.size(); i++){
			Block entity = (Block)TestMap.blocks.get(i);
			if(object.intersects(entity.blockPoly)){
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
