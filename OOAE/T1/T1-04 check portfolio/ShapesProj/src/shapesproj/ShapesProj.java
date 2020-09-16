
package shapesproj;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ShapesProj extends JFrame
{
    private static ArrayList<Drawable> shapes = new ArrayList<>();
    
    public static void main(String[] args)
    {
        myJFrame frame = new myJFrame();
        frame.setSize(600, 800);
        frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        DrawableCircle circle = new DrawableCircle(100, 100, 100);
        circle.setColour(Color.red);
        circle.setPosition(150, 175);
        DrawableRectangle rectangle = new DrawableRectangle(40, 40);
        rectangle.setColour(Color.green);
        rectangle.setPosition(50, 100);
        shapes.add(circle);
        shapes.add(rectangle);
    }
    
    
    
    public static class myJFrame extends JFrame
    {
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        for(Drawable d : shapes)
        {
            d.draw(g);
        }
    }
    }
    
}


