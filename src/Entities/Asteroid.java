package Entities;

import org.newdawn.slick.Graphics;

public class Asteroid extends Entity {

    public Asteroid (float x, float y) {
        super(x,y);
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
        graphics.drawRect(getX(), getY(), 10, 10);
    }
}
