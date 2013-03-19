package maps;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


public class Map {
	private TiledMap map;
	protected String NAME;
	private float killY;
	private float spawn1[], spawn2[];
	private int mapWidth, mapHeight;
	private int platform[] = {0, 0, 60, 0, 60, 60, 0, 60};
	private ArrayList<Object> blocks;

	public Map(String path, float killY, float spawn1[], float spawn2[]) throws SlickException{
		this.killY = killY;
		this.spawn1 = spawn1;
		this.spawn2 = spawn2;
		blocks = new ArrayList<Object>();
		map = new TiledMap(path);
		mapWidth = map.getWidth() * map.getTileWidth(); //gets the map width in pixels
		mapHeight = map.getHeight() * map.getTileHeight();
		
		for(int x = 0; x < map.getWidth(); x++){
			for (int y = 0; y < map.getHeight(); y++){
				int tileID = map.getTileId(x, y, 0);
				String tileType = map.getTileProperty(tileID, "block", "false");
				if(tileType.equals("true")){
					blocks.add(new Block(x * 60, y * 60, platform, "platform"));
				}
			}
		}
	}
	public TiledMap getMap(){
		return map;
	}
	public ArrayList<Object> getBlock(){
		return blocks;
	}
	public String getName(){
		return NAME;
	}
	public float getKillY(){
		return killY;
	}
	public float getSpawn1(int i){
		return spawn1[i];
	}
	public float getSpawn2(int i){
		return spawn2[i];
	}
}
