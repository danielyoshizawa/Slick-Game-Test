package game;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;

public class World extends BasicGame implements KeyListener {

    Circle circle;
    float x = 0.0f;
    float y = 0.0f;

    public World(String title) {
        super(title);
    }

    public void init(GameContainer gameContainer) throws SlickException {
        circle = new Circle(100, 150, 50);
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {
        circle.setLocation(x,y);
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        graphics.drawString("Hello Jacqueline", 10, 100);
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
}
