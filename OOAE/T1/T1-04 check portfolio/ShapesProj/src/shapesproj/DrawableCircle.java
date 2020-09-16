package shapesproj;
import java.awt.Color;
import java.awt.Graphics;

public class DrawableCircle extends Circle implements Drawable
{
    Color color;
    int x;
    int y;
    int height; 
    int width;
    public DrawableCircle(double radius, int width, int height)
    {
        super(radius);
        color = Color.BLACK;
        x = 0;
        y = 0;
        this.height = height;
        this.width = width;
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillOval(x, y, height, width);
    }
    
    @Override
    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void setColour(Color c)
    {
        color = c;
    }
}
