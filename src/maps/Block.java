package maps;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;

public class Block {
	public Polygon blockPoly;
	public String blockName;
	public Block(float x, float y, int points[], String type){
		blockPoly = new Polygon(new float[]{x + points[0], y + points[1],
											x + points[2], y + points[3],
											x + points[4], y + points[5],
											x + points[6], y + points[7]});
		
		blockName = type;
		
	}
}
