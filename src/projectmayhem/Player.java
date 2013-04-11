package projectmayhem;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;

import playablecharacters.Character;
import playablecharacters.Tails;

public class Player {
	private float x,y;
	private float velocityX, velocityY;
	private boolean isJumping, isAlive, renderAttack1Poly, isAttacking1, animProtected, hasBeenAttacked;
	private String name, animationName;
	private Character playerCharacter;
	private Polygon poly, attackEffectPoly, walkPoly, attackPoly, jumpPoly, idlePoly;
	private Polygon polygons[];
	private Animation playerLeft, playerRight;
	private Animation playerLeftJump, playerRightJump;
	private Animation playerLeftIdle, playerRightIdle;
	private Animation playerLeftAttack1, playerRightAttack1;
	private Animation character;
	private int rightKey, leftKey, jumpKey, attack1Key;
	private int currentHealth, maxHealth, reviveTime, numOfDeaths;
	private int facing;
	public static final int IDLELEFT = 0; public static final int IDLERIGHT = 1; public static final int LEFT = 2; public static final int RIGHT = 3; 
	public static final int JUMPLEFT = 4; public static final int JUMPRIGHT = 5; public static final int ATTACK1LEFT = 6; public static final int ATTACK1RIGHT = 7;
	
	public Player(String name) throws SlickException{
		this.name = name;
		numOfDeaths = 0;
		isAlive = true;
		
		playerCharacter = new Tails();
		poly = playerCharacter.getWalkPolygon();
		walkPoly = poly;
		attackPoly = playerCharacter.getAttackPolygon();
		jumpPoly = playerCharacter.getJumpPolygon();
		idlePoly = playerCharacter.getIdlePolygon();
		attackEffectPoly = playerCharacter.getAttackEffectPolygon();
		polygons = new Polygon[5];
		
		polygons[0] = poly;
		polygons[1] = walkPoly;
		polygons[2] = attackPoly;
		polygons[3] = jumpPoly;
		polygons[4] = idlePoly;
		
		playerLeft = new Animation(playerCharacter.getLeftSprite(), 100);
		playerRight = new Animation(playerCharacter.getRightSprite(), 100);
		playerLeftJump = new Animation(playerCharacter.getJumpLeftSprite(), 100);
		playerRightJump = new Animation(playerCharacter.getJumpRightSprite(), 100);
		playerLeftIdle = new Animation(playerCharacter.getIdleLeftSprite(), 100);
		playerRightIdle = new Animation(playerCharacter.getIdleRightSprite(), 100);
		playerLeftAttack1 = new Animation(playerCharacter.getAttack1LeftSprite(), 50);	
		playerRightAttack1 = new Animation(playerCharacter.getAttack1RightSprite(), 50);
		this.character = playerLeftIdle;
		animationName = "Idle";
		
		playerLeftJump.setLooping(false);
		playerRightJump.setLooping(false);   

	}
	public void triggerAttack1(){
		setAttacking1(true);
		if(facing == 0){
			setAnimation(Player.ATTACK1LEFT);
		}
		else{
			setAnimation(Player.ATTACK1RIGHT);
		}
		character.restart();
		animProtected = true;
	}
	public void resetAttack1PolyPosition(){
		attackEffectPoly.setX(poly.getX());
	}
	
	public void setX(float xpos){
		if(xpos > x){
			facing = 1;
		}
		else if(xpos < x){
			facing = 0;
		}
		x = xpos;
		for(int i = 0; i < polygons.length; i++){
			polygons[i].setX(x); //Automatically adjust the polygon x-value according to player x-value
		}
		if(isAttacking1 == true){
			if(facing == 1){
				attackEffectPoly.setX(poly.getWidth() + xpos);
			}
			else{
				attackEffectPoly.setX(xpos - attackEffectPoly.getWidth());
			}
		}
		else{
			attackEffectPoly.setX(xpos);
		}
	}
	public void setY(float ypos){
		y = ypos;
		for(int i = 0; i < polygons.length; i++){
			polygons[i].setY(ypos); //Automatically adjust the polygon y-value according to player y-value
		}
		attackEffectPoly.setY(y + playerCharacter.getAttack1PolyY());
	}
	public void setPolyX(float xpos){
		for(int i = 0; i < polygons.length; i++){
			polygons[i].setX(xpos); 
		}
	}
	public void setPolyY(float ypos){
		for(int i = 0; i < polygons.length; i++){
			polygons[i].setY(ypos); 
		}
	}
	public void setAttack1PolyX(float xpos){
		attackEffectPoly.setX(xpos);
	}
	public void setAttack1PolyY(float ypos){
		attackEffectPoly.setY(ypos);
	}
	public void setXVelocity(float xvel){
		velocityX = xvel;
	}
	public void setYVelocity(float yvel){
		velocityY = yvel;
	}
	public void setIsJumping(boolean jumping){
		isJumping = jumping;
	}
	public void setAnimation(int anim){
		if(animProtected == false){
			switch(anim){
			case 0: character = playerLeftIdle; animationName = "Idle Left"; poly = idlePoly; break;
			case 1: character = playerRightIdle; animationName = "Idle Right"; poly = idlePoly; break;
			case 2: character = playerLeft; animationName = "Left"; poly = walkPoly; break;
			case 3: character = playerRight; animationName = "Right"; poly = walkPoly; break;
			case 4: character = playerLeftJump; animationName = "Jump Left"; poly = jumpPoly; break;
			case 5: character = playerRightJump; animationName = "Jump Right";  poly = jumpPoly; break; 
			case 6: character = playerLeftAttack1; animationName = "Attack 1 Left"; poly = attackPoly; break;
			case 7: character = playerRightAttack1; animationName = "Attack 1 Right"; poly = attackPoly; break;
			}
		}
	}
	public void setCurrentHealth(int health){
		currentHealth = health;
	}
	public void setMaxHealth(int health){
		maxHealth = health;
	}
	public void setAlive(boolean alive){
		isAlive = alive;
	}
	public void setAttacking1(boolean atk){
		isAttacking1 = atk;
	}
	public void setAnimationProtected(boolean animprot){
		animProtected = animprot;
	}
	public void setHasBeenAttacked(boolean attacked){
		hasBeenAttacked = attacked;
	}
	public void setReviveTime(int time){
		reviveTime = time;
	}
	public void setNumOfDeaths(int num){
		numOfDeaths = num;
	}
	
	//SET METHODS FOR KEY CONFIG
	public void setMoveRightKey(int key){
		rightKey = key;
	}
	public void setMoveLeftKey(int key){
		leftKey = key;
	}
	public void setJumpKey(int key){
		jumpKey = key;
	}
	public void setAttack1Key(int key){
		attack1Key = key;
	}
	
	//-----------------------------
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public float getPolyX(){
		return poly.getX();
	}
	public float getPolyY(){
		return poly.getY();
	}
	public float getXVelocity(){
		return velocityX;
	}
	public float getYVelocity(){
		return velocityY;
	}
	public float getCenterX(){
		return  x + poly.getWidth() / 2;
	}
	public int getMaxHealth(){
		return maxHealth;
	}
	public int getCurrentHealth(){
		return currentHealth;
	}
	public int getReviveTime(){
		return reviveTime;
	}
	public int getFacingDirection(){
		//returns 1 for right, 0 for left
		return facing;
	}
	public int getFrameOfAttack1(){
		return playerCharacter.getFrameOfAttack1();
	}
	public int getNumOfDeaths(){
		return numOfDeaths;
	}
	public boolean isJumping(){
		return isJumping;
	}
	public boolean isAlive(){
		return isAlive;
	}
	public boolean isAttacking1(){
		return isAttacking1;
	}
	public boolean isAnimationProtected(){
		return animProtected;
	}
	public boolean getHasBeenAttacked(){
		return hasBeenAttacked;
	}
	public Animation getAnimation(){
		return character;
	}
	public Polygon getPolygon(){
		return poly;
	}
	public Polygon getAttack1Polygon(){
		return attackEffectPoly;
	}
	public String getName(){
		return name;
	}
	public String getAnimationName(){
		return animationName;
	}
	
	//GET METHODS FOR KEY CONFIG
	public int getMoveRightKey(){
		return rightKey;
	}
	public int getMoveLeftKey(){
		return leftKey;
	}
	public int getJumpKey(){
		return jumpKey;
	}
	public int getAttack1Key(){
		return attack1Key;
	}
	
	//public void setCharacter(Character character){
		//playerCharacter = character;
//	}

}
