package Entities;

import org.newdawn.slick.Graphics;

public class Asteroid extends Entity {

    public Asteroid (float x, float y) {
        super(x,y, 10, 10);
    }

    @Override
    public void Update() {
        setY(getY() + 1);
    }

    @Override
    public void Render(Graphics graphics) {
        graphics.drawRect(getX(), getY(), getWidth(), getWidth());
    }
}
