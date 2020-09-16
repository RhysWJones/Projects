package shapesproj;
import java.awt.Color;
import java.awt.Graphics;

interface Drawable
{
    void setColour(Color c);
    void setPosition(int x, int y);
    void draw(Graphics g);
}
