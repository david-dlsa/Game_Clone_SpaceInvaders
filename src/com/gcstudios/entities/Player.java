package com.gcstudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;


public class Player extends Entity{

	public boolean right, left;
	
	public boolean isShoting = false;
	
	public Player(int x, int y, int width, int height,double speed,BufferedImage sprite) {
		super(x, y, width, height,speed,sprite);
		
	}
	
	public void tick(){
		if(right) {
			x+=speed;
		}
		else if(left) {
			x-=speed;
		}
		
		if(x >= Game.WIDTH) {
			x = -16;
		}
		else if(x+16 <0) {
			x = Game.WIDTH;
		}
		
		
		//sistema de tiros
		if(isShoting) {
			isShoting = false;
			int xx = this.getX() + 2;
			int yy = this.getY();
			Bullet bullet1 = new Bullet(xx,yy,2,2,4,null);
			int xx2 = this.getX() + 12;
			int yy2 = this.getY();
			Bullet bullet2 = new Bullet(xx2,yy2,2,2,4,null);
			Game.entities.add(bullet1);
			Game.entities.add(bullet2);
		}
	}
	
}
