package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class GameScreen implements Screen {

	private TextureRegion textureRegion;
	private float x, y, witdh, height;
	private Batch batch;
	
	
	
	private Label label;
	private BitmapFont font;
	
	private Sound sound;

	
	
	@Override
	public void show() {
		this.x = 10;
		this.y = 10;
		this.witdh = 50;
		this.height = 50;
		this.batch = new SpriteBatch();
		Pixmap map = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
		map.setColor(Color.CYAN);
		map.fill();
		textureRegion = new TextureRegion(new Texture(map));
		map.dispose();
		
		LabelStyle style = new LabelStyle();
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("gameplay.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 30;
		BitmapFont font12 = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose(); 
		
		style.font = font12;
		label = new Label("FPS:", style);
		label.setBounds(10, 10, 100, 100);
		label.setVisible(true);
		
		font = font12;
		
		sound = Gdx.audio.newSound(Gdx.files.internal("explosion.mp3"));
		new Thread(() ->{
			while(true) {
				try {
					Thread.sleep(1000*5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sound.play(0.6F);
			}
		}).start();
	}

	@Override
	public void render(float delta) {

		batch.begin();
		font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 100, 100);
		font.draw(batch, "test ", 150, 500);
		
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			this.y += 10;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			this.y -= 10;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			this.x -= 10;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			this.x += 10;
		}
		batch.draw(textureRegion, x, y, witdh, height);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
