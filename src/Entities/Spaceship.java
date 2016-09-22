package Entities;

import org.newdawn.slick.Graphics;

public class Spaceship extends Entity {

    public Spaceship(float x, float y) {
        super(x,y, 20, 80);
    }

    public float getCenterX() {
        return getX() + (getWidth() / 2);
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
