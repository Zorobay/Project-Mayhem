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
				32, 0,
				32, 64, 
				0, 64});
		attackPoly = new Polygon(new float[]
				{0, 0,
				14, 0,
				14, 14,
				0, 14});
		
		leftSprite = new SpriteSheet("graphics/characters/moveleft.png", 32, 64);
		rightSprite = new SpriteSheet("graphics/characters/moveright.png", 32, 64);
		jumpSprite = new SpriteSheet("graphics/characters/moveleft.png", 32, 64);
		idleSprite = new SpriteSheet("graphics/characters/moveleft.png", 32, 64);
		attack1Sprite = new SpriteSheet("graphics/characters/moveleft.png", 32, 64);
		attack1Dmg = 20;
		attack1Range = 100;
		frameOfAttack1 = 0;
		
		attack1PolyY = poly.getHeight()/2 - attackPoly.getHeight()/2;
	}

	public Polygon performAttack1(Polygon poly, Animation anim) {
		System.out.println("Frame: " + anim.getFrame());
		Polygon origPoly = poly;
		
		if(anim.getFrame() != anim.getFrameCount()){
			return new Polygon(new float[]{
					poly.getX(), poly.getY(), 
					poly.getX() + poly.getWidth(), poly.getY(),
					poly.getX() + poly.getWidth(), poly.getY() + 20,
					poly.getX() + poly.getWidth() + 20, poly.getY() + 20,
					poly.getX() + poly.getWidth() + 20, poly.getY() + 40,
					poly.getX() + 32, poly.getY() + 40,
					poly.getX() + 32, poly.getY() + 64,
					poly.getX(), poly.getY() + 64});
		}
		else{
			return origPoly;
		}
	}
}
