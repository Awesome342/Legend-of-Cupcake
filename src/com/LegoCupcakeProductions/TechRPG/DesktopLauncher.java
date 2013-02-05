package com.LegoCupcakeProductions.TechRPG;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopLauncher {
	public static void main(String[] args) {
		new LwjglApplication(new TechRPG(), "Application Title", 1024, 512, false);
	}
}
