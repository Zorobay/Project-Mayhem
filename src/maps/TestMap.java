package maps;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import projectmayhem.Block;

public class TestMap extends Map{
	
	public TestMap(String path) throws SlickException{
		super(path, 608f, new float[]{600, 576-64-32}, new float[]{200, 576-64-32});
		NAME = "TestMap";
	}
}
