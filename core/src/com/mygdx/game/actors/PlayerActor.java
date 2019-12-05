package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PlayerActor extends Actor{
	
	
	private TextureRegion textureRegion;
	
	public PlayerActor() {
		/*Pixmap map = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
		map.setColor(Color.CYAN);
		map.fill();
		textureRegion = new TextureRegion(new Texture(map));
		map.dispose();*/
		textureRegion = new TextureRegion(new Texture(Gdx.files.internal("badlogic.jpg")));
		super.setBounds(0, 0, 50, 50);
	}
	@Override
	public void act(float delta) {
		
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			super.setY(super.getY() + 10);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			super.setY(super.getY() - 10);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			super.setX(super.getX() - 10);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			super.setX(super.getX() + 10);
		}
		super.act(delta);
	}
	
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(this.textureRegion, super.getX(), super.getY(), super.getWidth(), super.getHeight());
		super.draw(batch, parentAlpha);
	}

}
