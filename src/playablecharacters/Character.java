package playablecharacters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;

public abstract class Character {
	private final static String NAME = "Test Character";
	protected int attack1Dmg, attack1Range, frameOfAttack1;
	protected float attack1PolyY;
	protected SpriteSheet leftSprite, rightSprite;
	protected SpriteSheet jumpLeftSprite, jumpRightSprite;
	protected SpriteSheet idleLeftSprite, idleRightSprite;
	protected SpriteSheet attack1LeftSprite, attack1RightSprite;
	protected Polygon walkPoly, attackEffectPoly, attackPoly, jumpPoly, idlePoly; 
	
	public SpriteSheet getLeftSprite(){
		return leftSprite;
	}
	public SpriteSheet getRightSprite(){
		return rightSprite;
	}
	public SpriteSheet getJumpLeftSprite(){
		return jumpLeftSprite;
	}
	public SpriteSheet getJumpRightSprite(){
		return jumpRightSprite;
	}
	public SpriteSheet getIdleLeftSprite(){
		return leftSprite;
	}
	public SpriteSheet getIdleRightSprite(){
		return leftSprite;
	}
	public SpriteSheet getAttack1LeftSprite(){
		return attack1LeftSprite;
	}
	public SpriteSheet getAttack1RightSprite(){
		return attack1RightSprite;
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
	public Polygon getWalkPolygon(){
		return walkPoly;
	}
	public Polygon getAttackEffectPolygon(){
		return attackEffectPoly;
	}
	public Polygon getAttackPolygon(){
		return attackPoly;
	}
	public Polygon getJumpPolygon(){
		return jumpPoly;
	}
	public Polygon getIdlePolygon(){
		return idlePoly;
	}
}
