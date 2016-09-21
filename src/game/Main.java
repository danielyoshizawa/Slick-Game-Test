package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main{

    public static void main(String [] args) {
        World world = new World("Slick Test Game");

        try
        {
            AppGameContainer app = new AppGameContainer(world);
            app.setDisplayMode(500, 400, false);
            app.start();

        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }

        System.out.println("Testing...");
    }
}
