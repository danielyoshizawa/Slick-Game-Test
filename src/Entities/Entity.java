package Entities;

import org.newdawn.slick.Graphics;

public abstract class Entity {

    private float x = 0.0f;
    private float y = 0.0f;
    private boolean deleteInstance = false;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public abstract void Init();
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
}
