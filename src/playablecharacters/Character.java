package playablecharacters;

import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;

public class Character {
	private final static String NAME = "Test Character";
	SpriteSheet leftSprite;
	SpriteSheet rightSprite;
	SpriteSheet jumpSprite;
	SpriteSheet idleSprite;
	Polygon poly; 

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
	public String getName(){
		return NAME;
	}
	public Polygon getPolygon(){
		return poly;
	}
}
