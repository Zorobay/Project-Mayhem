package projectmayhem;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class Missile {
	
	private Image alive, death, active;
	private Animation aliveAnim, deathAnim;
	private boolean isAlive;
	private float x, y;
	
	public Missile(Image alive, Image death){
		 this.alive = alive;
		 this.death = death;
	}
	public Missile(Animation alive, Animation death){
		aliveAnim = alive;
		deathAnim = death;
	}
	
	public Image getImage(){
		return active;
	}
	
	public void setAlive(boolean alive){
		isAlive = alive;
	}
	public void setX(float x){
		this.x = x;
	}
	public void setY(float y){
		this.y = y;
	}
}
