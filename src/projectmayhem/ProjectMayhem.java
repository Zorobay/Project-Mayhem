package projectmayhem;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class ProjectMayhem extends BasicGameState{

	boolean showIntroText, showGameOverText, isNewGame;
	static int clicks;
	Double timePassed;
	ArrayList score;
	
	public ProjectMayhem(int ID){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		score = new ArrayList();
		showIntroText = true;
		showGameOverText = false;
		isNewGame = false;
		clicks = 0;
		time = new Chronometer("time");
	}

	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if(showIntroText){
			g.drawString("Click To Start!", 320, 300);
		}
		else if(showGameOverText){
			g.drawString("Game Over! To play again, press SPACE\nTo exit to score, press E", 220, 300);
		}
		else{
			g.drawString(Integer.toString(clicks), 400, 300);
			g.drawString(String.format("%.1f", time.getTimeSeconds()), 400, 150);
		}
		
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		Input input = gc.getInput();
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			showIntroText = false;
			clicks++;
			time.Start();
			if(isNewGame){
				clicks = 0;
				time.Restart();
				isNewGame = false;
				
			}
		}
		
		if(input.isKeyPressed(Input.KEY_SPACE)){
			showIntroText = true;
			isNewGame = true;
			showGameOverText = false;
		}
		
		if(time.isStarted()){
			if(time.getTimeSeconds() >= 30){
				showGameOverText = true;
				showIntroText = false;
			}
		}
		
	}
	
	public int getID() {
		return 0;
	}
	
	public static int getClicks(){
		return clicks;
	}
}