	package playablecharacters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;

public class TestCharacter extends Character{
	private final String NAME = "Test Character";
	public TestCharacter() throws SlickException{
		poly = new Polygon(new float[]
				{0, 0, 
				93, 0,
				93, 102, 
				0, 102});
		attackPoly = new Polygon(new float[]
				{0, 0,
				14, 0,
				14, 14,
				0, 14});
		
		leftSprite = new SpriteSheet("graphics/characters/walkright2.png", 92, 104);
		rightSprite = new SpriteSheet("graphics/characters/walkright2.png", 92, 104);
		jumpSprite = new SpriteSheet("graphics/characters/walkright2.png", 92, 104);
		idleSprite = new SpriteSheet("graphics/characters/walkright2.png", 92, 104);
		attack1Sprite = new SpriteSheet("graphics/characters/walkright2.png", 92, 104);
		attack1Dmg = 20;
		attack1Range = 100;
		frameOfAttack1 = 1;
		
		attack1PolyY = poly.getHeight()/2 - attackPoly.getHeight()/2;
	}
}
