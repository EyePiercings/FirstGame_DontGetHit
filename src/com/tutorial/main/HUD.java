package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	//Not going to have any other health variable in game
	//so it's okay to use a static variable
	//Normally don't use static variables
	public static float HEALTH = 100;
	
	public int bounds = 0;
	
	//RGB Values go from 0(Black) to 255(Full Array of Color)
	private float greenValue = 255;
	
	private int score = 0;
	private int level = 1;
	
	public void tick(){		
		HEALTH = Game.clamp(HEALTH, 0, 100 + (bounds/2));
		greenValue = HEALTH * 2;
		greenValue = Game.clamp(greenValue, 0, 255);
		
		score++;
	}

	public void render(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(15,  15, 200 + bounds, 32);
		//The Green Bar
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(15,  15, (int)HEALTH * 2, 32);
		//The White Border
		g.setColor(Color.white);
		g.drawRect(15,  15, 200 + bounds, 32);
		
		//drawString method draws strings onto the app
		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);
		g.drawString("Space for Shop", 15, 94);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
