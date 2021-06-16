package com.gcstudios.graficos;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.gcstudios.entities.Player;
import com.gcstudios.main.Game;
import com.gcstudios.world.World;

public class UI {
	public static int seconds = 0;
	public static int minutes = 0;
	public static int frames = 0;
	
	public void tick() {
		frames++;
		if(frames == 60) {
			//Passou 1 segundo
			frames = 0;
			seconds++;
			if(seconds == 60) {
				//Passou 1 minuto
				seconds = 0;
				minutes++;
				if(UI.minutes % 2 == 0) {
					World.CICLO++;
					if(World.CICLO > World.noite) {
						World.CICLO = 0;
					}
				}
			}
		}
	}
	
	public void render(Graphics g) {
		
		String formatTime = "";
		if(minutes < 10) {
			formatTime+="0"+minutes+":";
		}
		else {
			formatTime+=minutes+":";
		}
		if(seconds < 10) {
			formatTime+="0"+seconds;
		}
		else {
			formatTime+=seconds;
		}
		
		g.setColor(Color.CYAN);
		g.setFont(new Font("arial",Font.BOLD,23));
		g.drawString("Score: " + Game.score, 10, 24);
		
		
		g.setColor(Color.red);
		g.fillRect(Game.WIDTH * Game.SCALE - 170, 6, 150, 25);
		g.setColor(Color.green);
		g.fillRect(Game.WIDTH * Game.SCALE - 170, 6, (int)((Game.life/100) * 150), 25);
	}
	
}
