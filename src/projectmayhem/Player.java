package projectmayhem;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;

import playablecharacters.TestCharacter;

public class Player {
	
	private float x,y;
	private float velocityX, velocityY;
	private boolean isJumping, isAlive, renderAttack1Poly, isAttacking1, animProtected;
	private String name, animationName;
	private TestCharacter playerCharacter;
	private Polygon poly, attack1Poly, origPoly;
	private Animation playerLeft, playerRight, playerJump, playerIdle, playerAttack1, character;
	private int rightKey, leftKey, jumpKey, attack1Key;
	private int currentHealth, maxHealth;
	private int reviveTime;
	public static final int IDLE = 0; public static final int LEFT = 1; public static final int RIGHT = 2; public static final int JUMP = 3; 
	public static final int ATTACK1 = 4;
	
	public Player(String name){
		this.name = name;
		isAlive = true;
		
		try {
			playerCharacter = new TestCharacter();
		} catch (SlickException e) {System.out.println("failed to create Test Character!");}
		
		poly = playerCharacter.getPolygon();
		origPoly = poly;
		attack1Poly = playerCharacter.getAttackPolygon();
		
		playerLeft = new Animation(playerCharacter.getLeftSprite(), 200);
		playerRight = new Animation(playerCharacter.getRightSprite(), 200);
		playerJump = new Animation(playerCharacter.getJumpSprite(), 200);
		playerIdle = new Animation(playerCharacter.getIdleSprite(), 200);
		playerAttack1 = new Animation(playerCharacter.getAttack1Sprite(), 200);
		character = playerIdle;
		animationName = "Idle";
	}
	public void triggerAttack1(){
		setAttacking1(true);
		setAnimation(Player.ATTACK1);
		character.restart();
		animProtected = true;
		System.out.println("Current Frame: " + character.getFrame());
		if(getAnimation().getFrame() == playerCharacter.getFrameOfAttack1()){  //If the animation has movement before attack
			setAttack1PolyX(poly.getX() + poly.getWidth());
		}
	}
	public void resetAttack1PolyPosition(){
		attack1Poly.setX(poly.getX());
	}
	
	public void setX(float xpos){
		x = xpos;
		poly.setX(xpos); //Automatically adjust the polygon x-value according to player x-value
		if(isAttacking1 == true){
			attack1Poly.setX(poly.getWidth() + xpos);
		}
		else{
			attack1Poly.setX(xpos);
		}
	}
	public void setY(float ypos){
		y = ypos;
		poly.setY(ypos); //Automatically adjust the polygon y-value according to player y-value
		attack1Poly.setY(y + playerCharacter.getAttack1PolyY());
	}
	public void setPolyX(float xpos){
		poly.setX(xpos);
	}
	public void setPolyY(float ypos){
		poly.setY(ypos);
	}
	public void setAttack1PolyX(float xpos){
		attack1Poly.setX(xpos);
	}
	public void setAttack1PolyY(float ypos){
		attack1Poly.setY(ypos);
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
			case 0: character = playerIdle; animationName = "Idle"; break;
			case 1: character = playerLeft; animationName = "Left";break;
			case 2: character = playerRight; animationName = "Right"; break;
			case 3: character = playerJump; animationName = "Jump"; break;
			case 4: character = playerAttack1; animationName = "Attack1"; break;
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
	public void setReviveTime(int time){
		reviveTime = time;
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
	public Animation getAnimation(){
		return character;
	}
	public Polygon getPolygon(){
		return poly;
	}
	public Polygon getAttack1Polygon(){
		return attack1Poly;
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
