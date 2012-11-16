package projectmayhem;

import java.awt.Color;
import java.awt.Dimension;

import misc.Button;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Settings extends BasicGameState{

	public static int ID; 
	
	Image settingsmenu;
	Button fullscreenon, fullscreenoff;
	Button resolution;
	Button back;
	UnicodeFont font;
	String resolutionString;
	Dimension resList4_3[], resList16_9[], resList5_4[];
		
	public Settings(int ID){
		this.ID = ID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		font = new UnicodeFont("graphics/font/ANGRYBLU.TTF", 20, false, false);
		font.addGlyphs("1234567890*xX");
		font.getEffects().add(new ColorEffect(Color.WHITE));
		font.loadGlyphs();
		
		resList4_3 = new Dimension[4]; //Specify the available 4:3 resolutions
		resList4_3[0] = new Dimension(800,600);
		resList4_3[1] = new Dimension(1152, 864);
		resList4_3[2] = new Dimension(1400, 1050);
		resList4_3[3] = new Dimension(1600, 1200);
		
		resList5_4 = new Dimension[1];
		resList5_4[0] = new Dimension(1280, 1024);
		
		resList16_9 = new Dimension[4];
		resList16_9[0] = new Dimension(1024, 600);
		resList16_9[1] = new Dimension(1366, 768);
		resList16_9[2] = new Dimension(1600, 900);
		resList16_9[3] = new Dimension(1920, 1080);
		
		resolutionString = gc.getWidth() + "x" + gc.getHeight();
		
		settingsmenu = new Image("graphics/buttons/settingsmenu.png");
		fullscreenon = new Button(settingsmenu.getSubImage(0, 0, 232, 28), settingsmenu.getSubImage(0, 28, 232, 28), Button.MID(), Button.MID(), gc);
		fullscreenoff = new Button(settingsmenu.getSubImage(0, 56, 246, 28), settingsmenu.getSubImage(0, 84, 246, 28), Button.MID(), Button.MID(), gc);
		resolution = new Button(settingsmenu.getSubImage(0, 139, 113, 27), settingsmenu.getSubImage(0, 166, 113, 27), Button.MID(),0, Button.MID(),40, gc);
		back = new Button(settingsmenu.getSubImage(0, 112, 64, 27),settingsmenu.getSubImage(0, 112, 64, 27),Button.MID(),0,Button.MID(), 80, gc);
		
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		if(gc.isFullscreen()){
			fullscreenon.getGraphics().draw(fullscreenon.getX(), fullscreenon.getY());
		}
		else{
			fullscreenoff.getGraphics().draw(fullscreenoff.getX(), fullscreenoff.getY());
		}
		
		resolution.getGraphics().draw(resolution.getX(), resolution.getY());
		font.drawString(resolution.getX() + resolution.getWidth() + 5, resolution.getY(), resolutionString);
		back.getGraphics().draw(back.getX(), back.getY());
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		if(input.isKeyPressed(Input.KEY_B)){
			sbg.enterState(0);
		}
		
		if(gc.isFullscreen()){
			if(fullscreenon.isClicked()){
				gc.setFullscreen(false);
			}
		}
		else{
			if(fullscreenoff.isClicked()){
				gc.setFullscreen(true);
			}
		}
		
		if(resolution.isClicked()){
			System.out.println("Resolution was clicked!");
			System.out.println("Aspect Ratio: " + getAspectRatio(gc.getWidth(), gc.getHeight()));
			int newX = 0; int newY = 0;
			if(getAspectRatio(gc.getWidth(), gc.getHeight()) == 43){
				System.out.println("Aspect Ratio is 4:3!");
				int arrayPos = 0;
				for(int i = 0; i <= resList4_3.length; i++){
					if(resList4_3[i].getWidth() == gc.getWidth()){
						if(i == resList4_3.length - 1){
							arrayPos = 0;
						}
						else{
							arrayPos = i +1;
						}
						break;
					}
				}
				newX = (int) resList4_3[arrayPos].getWidth();
				newY = (int) resList4_3[arrayPos].getHeight();
			}
			
			if(getAspectRatio(gc.getWidth(), gc.getHeight()) == 54){
				System.out.println("Aspect Ratio is 5:4!");
				int arrayPos = 0;
				for(int i = 0; i <= resList5_4.length; i++){
					if(resList5_4[i].getWidth() == gc.getWidth()){
						if(i == resList5_4.length - 1){
							arrayPos = 0;
						}
						else{
							arrayPos = i +1;
						}
						break;
					}
				}
				newX = (int) resList5_4[arrayPos].getWidth();
				newY = (int) resList5_4[arrayPos].getHeight();
			}
			
			if(getAspectRatio(gc.getWidth(), gc.getHeight()) == 169){
				System.out.println("Aspect Ratio is 16:9");
				int arrayPos = 0;
				for(int i = 0; i <= resList16_9.length; i++){
					if(resList16_9[i].getWidth() == gc.getWidth()){
						System.out.println("X resolution is: " + resList16_9[i].getWidth() + ", position " + i);
						if(i == resList16_9.length - 1){
							arrayPos = 0;
						}
						else{
							arrayPos = i +1;
						}
						break;
					}
				}
				newX = (int) resList16_9[arrayPos].getWidth();
				newY = (int) resList16_9[arrayPos].getHeight();
			}
			ProjectMayhem.setResolution(newX, newY);
			resolutionString = gc.getWidth() + "x" + gc.getHeight();
			System.out.println("Setting resolution to: " + newX + "x" + newY);
		}
		if(back.isClicked()){
			sbg.enterState(0);
		}
			
	}
	
	public int getID(){
		return ID;
	}
	
	private int getAspectRatio(int x, int y){
		boolean xIs4_3 = false;
		boolean yIs4_3 = false;
		
		boolean xIs5_4 = false;
		boolean yIs5_4 = false;
		
		boolean xIs16_9 = false;
		boolean yIs16_9 = false;
		
		switch(x){ 
		case 800: xIs4_3 = true;  //Check for 4:3
		case 1152: xIs4_3 = true; 
		case 1400: xIs4_3 = true;
		case 1600: xIs4_3 = true; xIs16_9 = true;
		
		case 1280: xIs5_4 = true; //Check for 5:4
		
		case 1024: xIs16_9 = true;
		case 1366: xIs16_9 = true; //Check for 16:9
		case 1920: xIs16_9 = true;break;
		default: xIs4_3 = false; xIs5_4 = false; xIs16_9 = false; break;
		}
		
		switch(y){ 
		case 600: yIs4_3 = true; yIs16_9 = true; //Check for 4:3
		case 864: yIs4_3 = true; 
		case 1050: yIs4_3 = true;
		case 1200: yIs4_3 = true;
		
		case 1024: yIs5_4 = true; //Check for 5:4
		
		case 768: yIs16_9 = true; //Check for 16:9
		case 900: yIs16_9 = true;
		case 1080: yIs16_9 = true; break;
		default: yIs4_3 = false; yIs5_4 = false; yIs16_9 = false; break;
		}
		
		if(xIs4_3 && yIs4_3){
			return 43;
		}
		else if(xIs5_4 && yIs5_4){
			return 54;
		}
		else if(xIs16_9 && yIs16_9){
			return 169;
		}
		else{
			return 0;
		}
		
	}
}
