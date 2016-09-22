package game;

import Entities.Asteroid;
import Entities.Bullet;
import Entities.Entity;
import Entities.Spaceship;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;

import java.util.ArrayList;

// TODO : Just DO IT, refactorings will be done later
public class World extends BasicGame implements KeyListener, MouseListener {

    Circle circle;
    Spaceship spaceship;
    ArrayList<Entity> asteroidList = new ArrayList<>();
    ArrayList<Entity> bulletList = new ArrayList<>();
    int time = 0;
    int asteroidTime = 0;
    int asteroidDestroyed = 0;

    float x = 100.0f;
    float y = 150.0f;
    boolean mousePressed = false;

    public World(String title) {
        super(title);
    }

    public void init(GameContainer gameContainer) throws SlickException {
        circle = new Circle(100, 150, 50);
        spaceship = new Spaceship(250, 350);
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {
        circle.setCenterX(x);
        circle.setCenterY(y);
        spaceship.Update();

        // TODO : Ugliest way to do it, but well is done
        asteroidList.stream().filter(entity -> entity.HasCollision(bulletList)).forEach(entity -> {
            entity.MarkToDelete();
            asteroidDestroyed++;
        });

        bulletList.forEach(Entity::Update);
        bulletList.stream().filter(entity -> entity.IsOutOfTheScreen(gameContainer.getWidth(), gameContainer.getHeight())).forEach(Entity::MarkToDelete);


        // TODO : Create some timer mechanism
        if (asteroidTime >= 300) {
            asteroidList.forEach(Entity::Update);
            asteroidList.stream().filter(entity -> entity.IsOutOfTheScreen(gameContainer.getWidth(), gameContainer.getHeight())).forEach(Entity::MarkToDelete);
            asteroidTime = 0;
        } else {
            asteroidTime += i;
        }

        if (time >= 1000) {
            generateAsteroid();
            time = 0;
        } else {
            time += i;
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        graphics.drawString("Hello Jacqueline", 10, 100);
        graphics.drawString(Float.toString(x), 10, 120);
        graphics.drawString(Float.toString(y), 10, 140);
        graphics.drawString(Integer.toString(bulletList.size()), 10, 160);
        graphics.drawString("Destroyed : " + Integer.toString(asteroidDestroyed), 10, 180);
        graphics.draw(circle);
        spaceship.Render(graphics);


        // TODO: Refactor this
        for(Entity entity : asteroidList) {
            entity.Render(graphics);
        }

        for(Entity entity : bulletList) {
            entity.Render(graphics);
        }

        cleanEntities();
    }

    // TODO : Replace with the arrows
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_LEFT)
            spaceship.setX(spaceship.getX() - 10);
        if (key == Input.KEY_RIGHT)
            spaceship.setX(spaceship.getX() + 10);
        if (key == Input.KEY_UP)
            spaceship.setY(spaceship.getY() - 10);
        if (key == Input.KEY_DOWN)
            spaceship.setY(spaceship.getY() + 10);
        if (key == Input.KEY_SPACE)
            shoot(spaceship.getCenterX(), spaceship.getY());
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

    // TODO : Rethink this
    private void shoot(float x, float y) {
        bulletList.add(new Bullet(x, y));
    }

    private void generateAsteroid() {

        // TODO : Rethink
        int posX = (int)(Math.random() * 500);

        asteroidList.add(new Asteroid(posX,0));
    }

    // TODO : Refactor this
    private void cleanEntities() {
        asteroidList.removeIf(entity -> entity.IsMarkedToDelete());
        bulletList.removeIf(entity -> entity.IsMarkedToDelete());
    }
}
