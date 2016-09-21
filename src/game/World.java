package game;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.omg.CORBA.FloatHolder;

public class World extends BasicGame implements KeyListener, MouseListener{

    Circle circle;
    float x = 100.0f;
    float y = 150.0f;
    boolean mousePressed = false;

    public World(String title) {
        super(title);
    }

    public void init(GameContainer gameContainer) throws SlickException {
        circle = new Circle(100, 150, 50);
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {
        circle.setCenterX(x);
        circle.setCenterY(y);
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        graphics.drawString("Hello Jacqueline", 10, 100);
        graphics.drawString(Float.toString(x), 10, 120);
        graphics.drawString(Float.toString(y), 10, 140);
        graphics.draw(circle);
    }

    public void keyPressed(int key, char c) {
        if (c == 'a')
            x -= 10;
        if (c == 'd')
            x += 10;
        if (c == 'w')
            y -= 10;
        if (c == 's')
            y += 10;
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
