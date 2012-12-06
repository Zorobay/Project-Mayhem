package projectmayhem;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;

import playablecharacters.TestCharacter;

public class Player {
	
	private float x,y;
	private float velocityX, velocityY;
	private boolean isJumping, isAlive;
	private String name;
	private TestCharacter playerCharacter;
	private Polygon poly;
	private Animation playerLeft, playerRight, playerJump, playerIdle, character;
	private int rightKey, leftKey, jumpKey, attack1Key;
	private int currentHealth, maxHealth;
	private int reviveTime;
	public static final int IDLE = 0; public static final int LEFT = 1; public static final int RIGHT = 2; public static final int JUMP = 3;
	
	public Player(String name){
		this.name = name;
		isAlive = true;
		
		try {
			playerCharacter = new TestCharacter();
		} catch (SlickException e) {System.out.println("failed to create Test Character!");}
		
		poly = playerCharacter.getPolygon();
		
		playerLeft = new Animation(playerCharacter.getLeftSprite(), 200);
		playerRight = new Animation(playerCharacter.getRightSprite(), 200);
		playerJump = new Animation(playerCharacter.getJumpSprite(), 200);
		playerIdle = new Animation(playerCharacter.getIdleSprite(), 200);
		character = playerIdle;
	}
	public void triggerAttack1(){
		playerCharacter.performAttack1(poly);
	}
	
	public void setX(float xpos){
		x = xpos;
		poly.setX(x); //Automatically adjust the polygon x-value according to player x-value
	}
	public void setY(float ypos){
		y = ypos;
		poly.setY(y); //Automatically adjust the polygon y-value according to player y-value
	}
	public void setPolyX(float xpos){
		poly.setX(xpos);
	}
	public void setPolyY(float ypos){
		poly.setY(ypos);
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
		switch(anim){
		case 0: character = playerIdle; break;
		case 1: character = playerLeft; break;
		case 2: character = playerRight; break;
		case 3: character = playerJump; break;
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
	public boolean isJumping(){
		return isJumping;
	}
	public Animation getAnimation(){
		return character;
	}
	public Polygon getPolygon(){
		return poly;
	}
	public int getMaxHealth(){
		return maxHealth;
	}
	public int getCurrentHealth(){
		return currentHealth;
	}
	public boolean isAlive(){
		return isAlive;
	}
	public int getReviveTime(){
		return reviveTime;
	}
	public float getCenterX(){
		return  x + poly.getWidth() / 2;
	}
	public String getName(){
		return name;
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
