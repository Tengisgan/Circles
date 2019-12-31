package com.game.states;

import static com.game.projectiles.Bullet.bullets;
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import com.game.entities.Boss;
import com.game.entities.EmotionBoss;
import com.game.entities.Enemy;
import com.game.entities.Entity;
import com.game.entities.Player;
import com.game.projectiles.Bullet;

public class Play extends BasicGameState {
	
	private int id;
	public Play(int id) {
		this.id = id;
	}
	
	private Input input;
	private ArrayList<Entity> entities = new ArrayList<>();
	
	private Player player;
	
	

	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		container.getGraphics().setBackground(Color.decode("#2980B9"));
		input = container.getInput();
		
		player = new Player(container, 100, 100, 7);
		entities.add(player);
//		entities.add(new Enemy(container, 300, 300, 7));
		
		entities.add(new EmotionBoss(container, player, 2, 300, 300, 30));
		
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	    g.setAntiAlias(true);
	    
		for(int i=0; i<entities.size(); i++) {
			entities.get(i).render();
		}
		
		for(int i=0; i<Bullet.bullets.size(); i++) {
			if(Bullet.bullets.get(i).isAlive()) {
			    Bullet.bullets.get(i).render();
			}
		}
		
		
		if(input.isMouseButtonDown(0)) {
		    new Bullet(container, 0, player.getX(), player.getY(), input.getMouseX(), input.getMouseY(), 2, 3);
		}
		
		
	}
	

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	   
		for(int i=0; i<entities.size(); i++) {
			if(entities.get(i).isAlive()) {
				entities.get(i).update(delta);
			}else {
				entities.remove(i);
			}
		}
		
		for(int i=0; i<bullets.size(); i++) {
			if(bullets.get(i).isAlive()) {
				bullets.get(i).update();
				for(int j=0; j<entities.size(); j++) {
					if(entities.get(j).getId() != bullets.get(i).getId() && entities.get(j).intersects(bullets.get(i))) {
					    
//					    if(entities.get(j).isBoss()) {
//					        if(entities.get(j).isHappy()) {
//					            
//					        }
//					    }
					    
//					    if(entities.get(j).getId() == 2) {
//					        bullets.get(i).invertDx();
//		                    bullets.get(i).invertDy();
//		                    bullets.get(i).changeId(entities.get(j).getId());
//					    }else {
					        bullets.get(i).setAlive(false);
					        entities.get(j).decreaseHealth(1);
					        
//					    }
//					    System.out.println(entities.get(j).getId() + ", " + bullets.get(i).getId());
//					    bullets.get(i).invertDx();
//					    bullets.get(i).invertDy();
//					    bullets.get(i).changeId(entities.get(j).getId());
					}
				}
			}else {
				bullets.remove(i);
			}
		}
		
	}

	public int getID() {
		return id;
	}

}
