package com.game.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import com.game.projectiles.Bullet;
import com.game.utils.Vector;

public class EmotionBoss extends Boss {
    
    
    private Player player;
    
    private boolean performedAction = false;
    private int counter = 0;
    private Vector target;
    private float speed = 5;
    
    private int timer = 0;
    
    private int healthbarWidth = 750;
    private float scale;
    
    
    public EmotionBoss(GameContainer container, Player player, int id, float x, float y, int radius) {
        super(container, id, x, y, radius);
        this.player = player;
        this.health = 100;
        
        scale = healthbarWidth / (float) health;
        
    }

    public void render() {
        g.setColor(color);
        g.fill(shape);
        g.draw(shape);
        
        g.drawString("" + health, 200, 10);
        
        
//        g.setColor(Color.red);
//        g.fillRect(50, container.getHeight() - 65, scale * health, 25);
        g.setColor(Color.white);
//        g.drawRect(50, container.getHeight() - 65, healthbarWidth, 25);
        g.fillRoundRect(25, container.getHeight() - 20, healthbarWidth, 5, 5);
        g.setColor(Color.red);
        g.fillRoundRect(25, container.getHeight() - 20, scale * health, 5, 5);
        
        
        
    }
    
    public void update(int delta) {
        
        if(timer >= 2000) {
            chooseRandomMethod();
            timer = 0;
        }
        
           
        if(target != null) {
            Vector direction = Vector.sub(target, position);
            if(direction.magnitude() <= speed) {
                target = null;
            }else {
                direction.setMagnitude(speed);
                position.add(direction);
            }
        }
        
        if(player.intersects(this)) {
            player.decreaseHealth(1);
        }
        
        
        shape.setCenterX(position.x);
        shape.setCenterY(position.y);
        timer += delta;
    }
    
    private void chooseRandomMethod() {
        performedAction = false;
        int random = (int) (Math.random() * 2);
        if(random == 0) {
            angry();
        }else if(random == 1) {
            neutral();
        }
    }
    
    private void angry() { 
        color = Color.red;
        int numShots = 12 + (int) ((1F - (health / 100F)) * 24);
        float angle = 360 / (float) numShots;
        for(int i=0; i<numShots; i++) {
            float bulletX = position.x + (float) Math.cos(Math.toRadians(i * angle)) * radius;
            float bulletY = position.y + (float) Math.sin(Math.toRadians(i * angle)) * radius;
            new Bullet(container, id, position.x, position.y, bulletX, bulletY, 2, 3);
            target = new Vector(player.getPosition().x, player.getPosition().y);
        }
    }
    
    private void neutral() {
        color = Color.yellow;
        target = null;
        new Bullet(container, id, position.x, position.y, player.getPosition().x, player.getPosition().y, 25, 3);
    }
    
    private void happy() {
        
    }
    
}



