package Entities;

import org.newdawn.slick.Graphics;

public class Bullet extends Entity {

    public Bullet(float x, float y) {
        super(x,y, 5, 10);
    }

    @Override
    public void Init() {

    }

    @Override
    public void Update() {
        setY(getY() - 1);
    }

    @Override
    public void Render(Graphics graphics) {
        graphics.drawString("I", getX(), getY());
    }
}
