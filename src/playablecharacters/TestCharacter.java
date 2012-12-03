package playablecharacters;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;



public class TestCharacter{
	private final String NAME = "Test Character";
	SpriteSheet leftSprite;
	SpriteSheet rightSprite;
	SpriteSheet jumpSprite;
	SpriteSheet idleSprite;
	Polygon poly; 
	
	public TestCharacter() throws SlickException{
		poly = new Polygon(new float[]
				{0, 0, 
				32, 0,
				32, 64, 
				0, 64});
		
		leftSprite = new SpriteSheet("graphics/characters/moveleft.png", 32, 64);
		rightSprite = new SpriteSheet("graphics/characters/moveright.png", 32, 64);
		jumpSprite = new SpriteSheet("graphics/characters/moveleft.png", 32, 64);
		idleSprite = new SpriteSheet("graphics/characters/moveleft.png", 32, 64);
	}
	
	public SpriteSheet getLeftSprite(){
		return leftSprite;
	}
	public SpriteSheet getRightSprite(){
		return rightSprite;
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
