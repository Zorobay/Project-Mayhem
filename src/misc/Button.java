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
	int xoffset, yoffset;
	
	static final int MID = -1; static final int LEFTMID = -2; static final int RIGHTMID = -3;
	static final int MIDTOP = -4; static final int LEFTTOP= -5; static final int RIGHTTOP = -6;
	static final int MIDBOT = -7; static final int LEFTBOT= -8; static final int RIGHTBOT = -9;
	
	public Button(Image def, Image hover, int x, int xoffset, int y, int yoffset, GameContainer gc){ //all, with offsets
		this.def = def;
		this.hover = hover;
		this.gc = gc;
		this.xoffset = xoffset;
		this.yoffset = yoffset;
		
		switch(x){
		case -1: this.x = gc.getWidth()/2 - def.getWidth()/2 + xoffset; break;
		case -2: this.x = 0 + xoffset; break;
		case -3: this.x = gc.getWidth() - def.getWidth() + xoffset; break;
		case -4: this.x = gc.getWidth()/2 - def.getWidth() + xoffset;break;
		case -5: this.x = 0 + xoffset;break;
		case -6: this.x = gc.getWidth() - def.getWidth() + xoffset; break;
		case -7: this.x = gc.getWidth()/2 - def.getWidth() + xoffset;break;
		case -8: this.x = 0 + xoffset;break;
		case -9: this.x = gc.getWidth() - def.getWidth() + xoffset; break;
		default: this.x = x; break;
		}
		
		switch(y){
		case -1: this.y = gc.getHeight()/2 - def.getHeight()/2 + yoffset; break;
		case -2: this.y = gc.getHeight()/2 - def.getHeight()/2 + yoffset; break;
		case -3: this.y = gc.getHeight()/2 - def.getHeight()/2 + yoffset; break;
		case -4: this.y = 0 + yoffset;break;
		case -5: this.y = 0 + yoffset;break;
		case -6: this.y = 0 + yoffset;break;
		case -7: this.y = gc.getHeight() - def.getHeight() + yoffset; break;
		case -8: this.y = gc.getHeight() - def.getHeight() + yoffset; break;
		case -9: this.y = gc.getHeight() - def.getHeight() + yoffset; break;
		default: this.y = y; break;
		}
	}
	
	public Button(Image def, Image hover, int x, int y, GameContainer gc){ //all, except offsets
		this.def = def;
		this.hover = hover;
		this.gc = gc;
		
		switch(x){
		case -1: this.x = gc.getWidth()/2 - def.getWidth()/2; break;
		case -2: this.x = 0; break;
		case -3: this.x = gc.getWidth() - def.getWidth(); break;
		case -4: this.x = gc.getWidth()/2 - def.getWidth();break;
		case -5: this.x = 0;break;
		case -6: this.x = gc.getWidth() - def.getWidth(); break;
		case -7: this.x = gc.getWidth()/2 - def.getWidth();break;
		case -8: this.x = 0;break;
		case -9: this.x = gc.getWidth() - def.getWidth(); break;
		default: this.x = x; break;
		}
		
		switch(y){
		case -1: this.y = gc.getHeight()/2 - def.getHeight()/2; break;
		case -2: this.y = gc.getHeight()/2 - def.getHeight()/2; break;
		case -3: this.y = gc.getHeight()/2 - def.getHeight()/2; break;
		case -4: this.y = 0;break;
		case -5: this.y = 0;break;
		case -6: this.y = 0;break;
		case -7: this.y = gc.getHeight() - def.getHeight(); break;
		case -8: this.y = gc.getHeight() - def.getHeight(); break;
		case -9: this.y = gc.getHeight() - def.getHeight(); break;
		default: this.y = y; break;
		}
	}
	
	public Button(Image def, int x, int y, GameContainer gc){ //A static image and no offsets
		this.def = def;
		hover = null;
		this.gc = gc;

		switch(x){
		case -1: this.x = gc.getWidth()/2 - def.getWidth()/2; break;
		case -2: this.x = 0; break;
		case -3: this.x = gc.getWidth() - def.getWidth(); break;
		case -4: this.x = gc.getWidth()/2 - def.getWidth();break;
		case -5: this.x = 0;break;
		case -6: this.x = gc.getWidth() - def.getWidth(); break;
		case -7: this.x = gc.getWidth()/2 - def.getWidth();break;
		case -8: this.x = 0;break;
		case -9: this.x = gc.getWidth() - def.getWidth(); break;
		default: this.x = x; break;
		}
		
		switch(y){
		case -1: this.y = gc.getHeight()/2 - def.getHeight()/2; break;
		case -2: this.y = gc.getHeight()/2 - def.getHeight()/2; break;
		case -3: this.y = gc.getHeight()/2 - def.getHeight()/2; break;
		case -4: this.y = 0;break;
		case -5: this.y = 0;break;
		case -6: this.y = 0;break;
		case -7: this.y = gc.getHeight() - def.getHeight(); break;
		case -8: this.y = gc.getHeight() - def.getHeight(); break;
		case -9: this.y = gc.getHeight() - def.getHeight(); break;
		default: this.y = y; break;
		}
	}
	
	public Button(Image def, int x, int xoffset, int y, int yoffset, GameContainer gc){ //A static image with offsets
		this.def = def;
		this.hover = null;
		this.gc = gc;
		this.xoffset = xoffset;
		this.yoffset = yoffset;
		
		switch(x){
		case -1: this.x = gc.getWidth()/2 - def.getWidth()/2 + xoffset; break;
		case -2: this.x = 0 + xoffset; break;
		case -3: this.x = gc.getWidth() - def.getWidth() + xoffset; break;
		case -4: this.x = gc.getWidth()/2 - def.getWidth() + xoffset;break;
		case -5: this.x = 0 + xoffset;break;
		case -6: this.x = gc.getWidth() - def.getWidth() + xoffset; break;
		case -7: this.x = gc.getWidth()/2 - def.getWidth() + xoffset;break;
		case -8: this.x = 0 + xoffset;break;
		case -9: this.x = gc.getWidth() - def.getWidth() + xoffset; break;
		default: this.x = x; break;
		}
		
		switch(y){
		case -1: this.y = gc.getHeight()/2 - def.getHeight()/2 + yoffset; break;
		case -2: this.y = gc.getHeight()/2 - def.getHeight()/2 + yoffset; break;
		case -3: this.y = gc.getHeight()/2 - def.getHeight()/2 + yoffset; break;
		case -4: this.y = 0 + yoffset;break;
		case -5: this.y = 0 + yoffset;break;
		case -6: this.y = 0 + yoffset;break;
		case -7: this.y = gc.getHeight() - def.getHeight() + yoffset; break;
		case -8: this.y = gc.getHeight() - def.getHeight() + yoffset; break;
		case -9: this.y = gc.getHeight() - def.getHeight() + yoffset; break;
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
	
	public boolean isClicked(){
		Input input = gc.getInput();
		if((input.getMouseX() >= x && input.getMouseX() <= x + def.getWidth()) && (input.getMouseY() > y && input.getMouseY() < y + def.getHeight())){ //Check to see if mouse is over button
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
				return true;
			}
		}
		return false;
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
	
	public int getWidth(){
		return active.getWidth();
	}
	
	public int getHeight(){
		return active.getHeight();
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
	public static int MIDTOP(){
		return MIDTOP;
	}
	public static int LEFTTOP(){
		return LEFTTOP;
	}
	public static int RIGHTTOP(){
		return RIGHTTOP;
	}
	public static int MIDBOT(){
		return MIDBOT;
	}
	public static int LEFTBOT(){
		return LEFTBOT;
	}
	public static int RIGHTBOT(){
		return RIGHTBOT;
	}
}
