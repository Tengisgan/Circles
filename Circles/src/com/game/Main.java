package com.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import com.game.states.Menu;
import com.game.states.Play;

public class Main extends StateBasedGame {
	
	public Main(String name) {
		super(name);
	}

	public void initStatesList(GameContainer container) throws SlickException {
	    addState(new Menu(0));
		addState(new Play(1));
		enterState(1);
	}
	
	public static void main(String[] args) {
		AppGameContainer app = null;
		try {
            app = new AppGameContainer(new Main("Circles"));
            app.setTargetFrameRate(60);
            app.setShowFPS(false);
            app.setAlwaysRender(true);
            app.setVerbose(false);
            app.setDisplayMode(800, 600, false);
            app.start();
        }catch(SlickException e) {
            e.printStackTrace();
        }
	}

}
