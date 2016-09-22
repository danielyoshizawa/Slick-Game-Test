package Entities;

import org.newdawn.slick.Graphics;

public class Bullet implements Entity {

    private float x = 0.0f;
    private float y = 0.0f;
    private boolean deleteInstance = false;

    public Bullet(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void Init() {

    }

    @Override
    public void Update() {
        setY(getY() + 1);
    }

    @Override
    public void Render(Graphics graphics) {
        graphics.drawString("I", x, y);
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

    public boolean IsOutOfTheScreen(float height) {
        return y >= height;
    }

    @Override
    public void MarkToDelete() {
        deleteInstance = true;
    }

    @Override
    public boolean IsMarkedToDelete() {
        return deleteInstance;
    }
}
