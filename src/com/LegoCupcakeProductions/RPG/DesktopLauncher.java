package com.LegoCupcakeProductions.RPG;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopLauncher {
	public static void main(String[] args) {
		new LwjglApplication(new RPG(), "Legend of Cupcake", 1024, 512, false);
	}
}