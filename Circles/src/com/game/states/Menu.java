package com.game.states;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import com.game.projectiles.Bullet;

public class Menu extends BasicGameState {

    private int id;
    
    public Menu(int id) {
        this.id = id;
    }
    
    private Input input;
    private ArrayList<String> options = new ArrayList<>();
    
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        container.getGraphics().setBackground(Color.decode("#2980B9"));
        options.add("Play");
        options.add("Instructions");
        options.add("Settings");
        options.add("Quit");
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setAntiAlias(true);
        g.setColor(Color.white);
        for (int i = 0; i < options.size(); i++) {
            int xPosition = container.getWidth() / 2 - (options.get(i).length() * 8) / 2;
            int yPosition = 200 + i*30;
            g.drawString(options.get(i), xPosition, yPosition);
            
        }
        
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
    }

    public int getID() {
        return 0;
    }

}
