package playablecharacters;

import java.io.IOException;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;

public class Missile {
	
	private Image alive, death, active;
	private Animation aliveAnim, deathAnim;
	private ParticleSystem particleSystem;
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
	public Missile(String path) throws IOException{
		particleSystem = ParticleIO.loadConfiguredSystem(path);
	}
	
	public ParticleSystem getParticle(){
		return particleSystem;
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
