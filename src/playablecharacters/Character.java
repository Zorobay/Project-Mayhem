package playablecharacters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;

public abstract class Character {
	private final static String NAME = "Test Character";
	protected int attack1Dmg, attack1Range, frameOfAttack1;
	protected float attack1PolyY;
	protected SpriteSheet leftSprite;
	protected SpriteSheet rightSprite;
	protected SpriteSheet jumpSprite;
	protected SpriteSheet idleSprite;
	protected SpriteSheet attack1Sprite;
	protected Polygon poly, attackPoly; 

	abstract Polygon performAttack1(Polygon poly, Animation anim);
	
	
	public SpriteSheet getLeftSprite(){
		return leftSprite;
	}
	public SpriteSheet getRightSprite(){
		return leftSprite;
	}
	public SpriteSheet getJumpSprite(){
		return leftSprite;
	}
	public SpriteSheet getIdleSprite(){
		return leftSprite;
	}
	public SpriteSheet getAttack1Sprite(){
		return attack1Sprite;
	}
	//CHARACTER ATTACKS
	public int getAttack1Dmg(){
		return attack1Dmg;
	}
	public int getFrameOfAttack1(){
		return frameOfAttack1;
	}
	public float getAttack1Range(){
		return attack1Range;
	}
	public float getAttack1PolyY(){
		return attack1PolyY;
	}
	public String getName(){
		return NAME;
	}
	public Polygon getPolygon(){
		return poly;
	}
	public Polygon getAttackPolygon(){
		return attackPoly;
	}
}
