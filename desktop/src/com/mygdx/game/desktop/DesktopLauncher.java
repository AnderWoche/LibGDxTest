
package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		
		config.useGL30 = false;
		config.title = "Ein tolles Test Spiel!";
		config.foregroundFPS = 500;
		config.backgroundFPS = 10;
		config.width = 1280;
		config.height = 720;
		config.vSyncEnabled = false;
		
		
		new LwjglApplication(new MyGdxGame(), config);
	}
}
