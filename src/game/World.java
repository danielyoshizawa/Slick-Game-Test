package game;

import Entities.Spaceship;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;

public class World extends BasicGame implements KeyListener, MouseListener {

    Circle circle;
    Spaceship spaceship;
    float x = 100.0f;
    float y = 150.0f;
    boolean mousePressed = false;

    public World(String title) {
        super(title);
    }

    public void init(GameContainer gameContainer) throws SlickException {
        circle = new Circle(100, 150, 50);
        spaceship = new Spaceship();
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {
        circle.setCenterX(x);
        circle.setCenterY(y);
        spaceship.Update();
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        graphics.drawString("Hello Jacqueline", 10, 100);
        graphics.drawString(Float.toString(x), 10, 120);
        graphics.drawString(Float.toString(y), 10, 140);
        graphics.draw(circle);
        spaceship.Render(graphics);
    }

    public void keyPressed(int key, char c) {
        if (c == 'a')
            spaceship.SetX(spaceship.GetX() - 10);
        if (c == 'd')
            spaceship.SetX(spaceship.GetX() + 10);
        if (c == 'w')
            spaceship.SetY(spaceship.GetY() - 10);
        if (c == 's')
            spaceship.SetY(spaceship.GetY() + 10);
    }

    public void mousePressed(int button, int x, int y) {
        if (circle.contains(x, y)) {
            mousePressed = true;
        }
    }

    public void mouseReleased(int button, int x, int y) {
        mousePressed = false;
    }

    public void mouseDragged(int oldx, int oldy, int newx, int newy) {
        if (mousePressed) {
            x = newx;
            y = newy;
        }
    }
}
