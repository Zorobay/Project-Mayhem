package maps;

import org.newdawn.slick.SlickException;

public class BecauseGrass extends Map{

	public BecauseGrass(String path) throws SlickException{
		super(path, 1200, new float[]{240, 660-120}, new float[]{1380, 240-120});
		NAME = "Because Grass";
	}
}
