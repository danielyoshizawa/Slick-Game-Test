package Entities;

import org.newdawn.slick.Graphics;

public class Spaceship implements Entity{

    private float x = 0.0f;
    private float y = 0.0f;

    public Spaceship() {

    }

    public void SetX(float x) {
        this.x = x;
    }

    public float GetX() {
        return x;
    }

    public void SetY(float y) {
        this.y = y;
    }

    public float GetY() {
        return y;
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

}
