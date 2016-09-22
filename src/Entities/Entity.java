package Entities;

import org.newdawn.slick.Graphics;

public interface Entity {

    public void Init();
    public void Update();
    public void Render(Graphics graphics);
    public boolean IsOutOfTheScreen(float width, float height);
    public void MarkToDelete();
    public boolean IsMarkedToDelete();
}
