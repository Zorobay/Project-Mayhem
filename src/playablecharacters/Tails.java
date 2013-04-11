package playablecharacters;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;

public class Tails extends Character{

	private final String NAME = "Test Character";
	public Tails() throws SlickException{
		walkPoly = new Polygon(new float[]
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
				58, 0,
				58, 53,
				0, 53				
				});
		
		idlePoly = new Polygon(new float[]
				{0, 0,
				42, 0,
				42, 35,
				0, 35
				});
		
		leftSprite = new SpriteSheet("graphics/characters/Tails/WalkLeft.png", 43, 34);
		rightSprite = new SpriteSheet("graphics/characters/Tails/WalkRight.png", 43, 34);
		jumpLeftSprite = new SpriteSheet("graphics/characters/Tails/JumpLeft.png", 38, 39);
		jumpRightSprite = new SpriteSheet("graphics/characters/Tails/JumpRight.png", 38, 39);
		idleLeftSprite = new SpriteSheet("graphics/characters//Tails/IdleLeft.png", 42, 35);
		idleRightSprite = new SpriteSheet("graphics/characters/Tails/IdleRight.png", 42, 35);
		attack1LeftSprite = new SpriteSheet("graphics/characters/Tails/AttackLeft.png", 58, 53);
		attack1RightSprite = new SpriteSheet("graphics/characters/Tails/AttackRight.png", 58, 53);
		attack1Dmg = 20;
		attack1Range = 100;
		frameOfAttack1 = 7;
		
		attack1PolyY = walkPoly.getHeight()/2 - attackEffectPoly.getHeight()/2;

	}
}
