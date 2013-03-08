package com.LegoCupcakeProductions.RPG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Item {
	public Rect ImgRect;
	public Texture Img;
	public TextureRegion ImgClip;
	public int power;
	public String name;
	
	public Item(String filename, String name, int x, int y, int frame, int direction, int w, int h, int power) {
		ImgRect = new Rect(x, y, w, h);
		Img = new Texture(filename);
		ImgClip = new TextureRegion(Img, frame, direction, w, h);
		this.power = power;
		this.name = name;
	}
	
	public void printText() {
		System.out.println("You got a " + name);
	}
}
