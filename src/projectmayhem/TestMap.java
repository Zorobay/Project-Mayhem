package projectmayhem;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class TestMap {
	public static TiledMap testMap;
	private static int mapWidth, mapHeight;
	private int platform[] = {0, 0, 32, 0, 32, 32, 0, 32};
	public static ArrayList<Object> blocks;
	
	public TestMap(String path) throws SlickException{
		blocks = new ArrayList<Object>();
		testMap = new TiledMap(path);
		mapWidth = testMap.getWidth() * testMap.getTileWidth(); //gets the map width in pixels
		mapHeight = testMap.getHeight() * testMap.getTileHeight();
		
		for(int x = 0; x < testMap.getWidth(); x++){
			for (int y = 0; y < testMap.getHeight(); y++){
				int tileID = testMap.getTileId(x, y, 0);
				String tileType = testMap.getTileProperty(tileID, "platform", "true");
				if(tileType.equals("true")){
					blocks.add(new Block(x * 32, y * 32, platform, "platform"));
				}
			}
		}
	}
}
