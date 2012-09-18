package misc;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class Button {
	
	Image def;
	Image hover;
	Image active;
	GameContainer gc; 
	int x, y;
	static final int MID = -1; static final int LEFTMID = -2; static final int RIGHTMID = -3;
	
	public Button(Image def, Image hover, int x, int y, GameContainer gc){
		this.def = def;
		this.hover = hover;
		this.gc = gc;
		
		switch(x){
		case -1: this.x = gc.getWidth()/2 - def.getWidth()/2; break;
		case -2: this.x = 0; break;
		case -3: this.x = gc.getWidth() - def.getWidth(); break;
		default: this.x = x; break;
		}
		
		switch(y){
		case -1: this.y = gc.getHeight()/2 - def.getHeight()/2; break;
		case -2: this.y = gc.getHeight()/2 - def.getHeight()/2; break;
		case -3: this.y = gc.getHeight()/2 - def.getHeight()/2; break;
		default: this.y = y; break;
		}
	}
	
	public Button(Image def, int x, int y, GameContainer gc){
		this.def = def;
		hover = null;
		this.gc = gc;

		switch(x){
		case -1: this.x = gc.getWidth()/2 - def.getWidth()/2; break;
		case -2: this.x = 0; break;
		case -3: this.x = gc.getWidth() - def.getWidth(); break;
		default: this.x = x; break;
		}
		
		switch(y){
		case -1: this.y = gc.getHeight()/2 - def.getHeight()/2; break;
		case -2: this.y = gc.getHeight()/2 - def.getHeight()/2; break;
		case -3: this.y = gc.getHeight()/2 - def.getHeight()/2; break;
		default: this.y = y; break;
		}
	}
	
	public Image getGraphics(){
		mouseIsHovering();
		return active;
	}
	
	private void mouseIsHovering(){
		Input input = gc.getInput();
		
		if((input.getMouseX() >= x && input.getMouseX() <= x + def.getWidth()) && (input.getMouseY() > y && input.getMouseY() < y + def.getHeight())){ //Check to see if mouse is over button
			if(hover != null){
				active = hover;
			}
		}
		else{
			active = def;
		}
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public static int MID(){
		return MID;
	}
	
	public static int LEFTMID(){
		return LEFTMID;
	}
	
	public static int RIGHTMID(){
		return RIGHTMID;
	}
}
