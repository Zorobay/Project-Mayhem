package playablecharacters;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;

public class Tails extends Character{

	private final String NAME = "Test Character";
	public Tails() throws SlickException{
		poly = new Polygon(new float[]
				{0, 0, 
				42, 0,
				42, 34, 
				0, 34});
		attackEffectPoly = new Polygon(new float[]
				{0, 0,
				14, 0,
				14, 14,
				0, 14});
		
		jumpPoly = new Polygon(new float[]
				{0, 0,
				37, 0,
				37, 39,
				0, 39
				});
		
		attackPoly = new Polygon(new float[]
				{0, 0,
				39, 0,
				39, 35,
				0, 35				
				});
		
		leftSprite = new SpriteSheet("graphics/characters/Tails/WalkLeft.png", 43, 33, 1);
		rightSprite = new SpriteSheet("graphics/characters/walkright2.png", 92, 104);
		jumpSprite = new SpriteSheet("graphics/characters/Tails/Jump.png", 37, 39, 1);
		idleSprite = new SpriteSheet("graphics/characters/walkright2.png", 92, 104);
		attack1Sprite = new SpriteSheet("graphics/characters/Tails/Attack.png", 58, 53);
		attack1Dmg = 20;
		attack1Range = 100;
		frameOfAttack1 = 1;
		
		attack1PolyY = poly.getHeight()/2 - attackEffectPoly.getHeight()/2;

	}
}
