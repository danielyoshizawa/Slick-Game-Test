package Entities;

import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public abstract class Entity {

    // TODO : Create a Box class or something like this
    private float x = 0.0f;
    private float y = 0.0f;
    private float height = 0.0f;
    private float width = 0.0f;
    private boolean deleteInstance = false;

    public Entity(float x, float y, float height, float width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public abstract void Update();
    public abstract void Render(Graphics graphics);

    public void MarkToDelete() {
        deleteInstance = true;
    }

    public boolean IsMarkedToDelete() {
        return deleteInstance;
    }

    public boolean IsOutOfTheScreen(float width, float height) {
        return getY() >= height || getY() < 0 || getX() >= width || getX() < 0;
    }

    // TODO : Change to a Box or something like that
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    // TODO : Improve this, also remember to collide Asteroids against Bullets
    public boolean HasCollision(ArrayList<Entity> entityList) {
        for(Entity entity : entityList) {
            if (entity.getX() > x - 10 && entity.getX() < x + 20 && entity.getY() > y - 10 && entity.getY() < y + 20) {
                entity.MarkToDelete();
                return true;
            }
        }
        return false;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
