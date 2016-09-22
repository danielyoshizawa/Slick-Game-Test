package Entities;

import org.newdawn.slick.Graphics;

public class Spaceship extends Entity {

    private float width = 0.0f;

    public Spaceship(float x, float y) {
        super(x,y);
        width = 80.0f;

    }

    public float getCenterX() {
        return getX() + (width / 2);
    }

    @Override
    public void Init() {

    }

    @Override
    public void Update() {

    }

    @Override
    public void Render(Graphics graphics) {
        graphics.drawString("SpaceShip", getX(), getY());
    }

    @Override
    public boolean IsOutOfTheScreen(float width, float height) {
        return false;
    }
}
