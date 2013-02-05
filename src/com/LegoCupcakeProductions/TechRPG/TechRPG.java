package com.LegoCupcakeProductions.TechRPG;

import com.badlogic.gdx.ApplicationListener;

public class TechRPG implements ApplicationListener {
	Graphics Sprite;
	
	@Override
	public void create() {
		Sprite = new Graphics();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		Sprite.draw();
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

}
