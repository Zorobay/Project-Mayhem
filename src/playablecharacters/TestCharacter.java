package playablecharacters;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;

public class TestCharacter extends Character{
	private final String NAME = "Test Character";
	//SpriteSheet leftSprite;
	//SpriteSheet rightSprite;
	//SpriteSheet jumpSprite;
	//SpriteSheet idleSprite;
	//Polygon poly; 
	
	public TestCharacter() throws SlickException{
		poly = new Polygon(new float[]
				{0, 0, 
				0, 64,
				32, 64, 
				32, 0});
		
		leftSprite = new SpriteSheet("graphics/characters/moveleft.png", 32, 64);
		rightSprite = new SpriteSheet("graphics/characters/moveright.png", 32, 64);
		jumpSprite = new SpriteSheet("graphics/characters/moveleft.png", 32, 64);
		idleSprite = new SpriteSheet("graphics/characters/moveleft.png", 32, 64);
		attack1Dmg = 20;
		attack1Range = 100;
	}

	public void performAttack1(Polygon poly) {
		poly.setAllowDuplicatePoints(true);
		poly.addPoint(poly.getX() + 56, poly.getY() + 20);
		poly.addPoint(poly.getX() + 56, poly.getY() + 40);
		
		
	}
}
