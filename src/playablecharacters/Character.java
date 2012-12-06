package playablecharacters;

import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;

public abstract class Character {
	private final static String NAME = "Test Character";
	protected int attack1Dmg, attack1Range;
	protected SpriteSheet leftSprite;
	protected SpriteSheet rightSprite;
	protected SpriteSheet jumpSprite;
	protected SpriteSheet idleSprite;
	protected Polygon poly; 

	abstract void performAttack1(Polygon poly);
	
	
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
	//CHARACTER ATTACKS
	public int getAttack1Dmg(){
		return attack1Dmg;
	}
	public float getAttack1Range(){
		return attack1Range;
	}
	public String getName(){
		return NAME;
	}
	public Polygon getPolygon(){
		return poly;
	}
}
