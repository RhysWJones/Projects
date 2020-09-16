package shapesproj;

import java.awt.Color;
import java.awt.Graphics;

public class DrawableRectangle extends Rectangle implements Drawable
{
    Color color;
    int x;
    int y;
    int height; 
    int width;
    public DrawableRectangle(double height, double width)
    {
        super(height, width);
        color = Color.BLACK;
        x = 0;
        y = 0;
        this.height = (int) height;
        this.width = (int) width;
    }

    @Override
    public void setColour(Color c)
    {
        color = c;
    }

    @Override
    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
}
