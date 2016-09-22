package Entities;

import org.newdawn.slick.Graphics;

public class Spaceship implements Entity{

    private float x = 0.0f;
    private float y = 0.0f;
    private float width = 0.0f;
    private boolean deleteInstance = false;

    public Spaceship(float x, float y) {
        width = 80.0f;
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public float getCenterX() {
        return x + (width / 2);
    }

    @Override
    public void Init() {

    }

    @Override
    public void Update() {

    }

    @Override
    public void Render(Graphics graphics) {
        graphics.drawString("SpaceShip", x, y);
    }

    @Override
    public boolean IsOutOfTheScreen(float width, float height) {
        return true;
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
