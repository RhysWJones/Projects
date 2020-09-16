
import java.awt.*;
import javax.swing.*;

/**
 * Adapted from Liang Introduction to Java programming Exercise 24.2
 */
public class RaceCarPanel extends JPanel
{

    private RaceCar[] theCars = new RaceCar[4];
    private Thread[] theThreads = new Thread[4];
    int laneHeight;

    public RaceCarPanel()
    {
        // create the cars
        for (int i = 0; i < theCars.length; i++)
        {
            theCars[i] = new RaceCar(i);
        }
    }

    public void go()
    {
        for (int i = 0; i < theCars.length; i++)
        {
            theCars[i].reset();
            theThreads[i] = null;   // stop any currently running thread
            theThreads[i] = new Thread(theCars[i]);
            theThreads[i].start();
        }
    }

    public void stop()
    {
        for (int i = 0; i < theCars.length; i++)
        {
            theThreads[i] = null;
        }
    }

    private synchronized void goThroughNarrows(RaceCar rc)
    {
        rc.setInNarrows(true);
        try
        {
            while (rc.getXPos() < 700)
            {
                rc.advance();
                Thread.sleep((int) (Math.random() * 50));
            }
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
        rc.setInNarrows(false);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // draw the track
        laneHeight = getHeight() / 4;
        for (int i = 1; i <= 4; i++)
        {
            g.drawLine(0, laneHeight * i - 1, 400, laneHeight * i - 1);
        }

        // draw the narrows
        g.drawLine(500, (int) (laneHeight * 1.5), 700, (int) (laneHeight * 1.5));
        g.drawLine(500, (int) (laneHeight * 2.5), 700, (int) (laneHeight * 2.5));
        for (RaceCar rc : theCars)
        {
            rc.display(g);
        }
    }

    class RaceCar implements Runnable
    {

        private int xPos = 0;
        private int yPos;
        private int num;
        private int speed = 2;
        private Color colour;

        public RaceCar(int num)
        {
            this.num = num;
        }

        public void reset()
        {
            xPos = 0;
            yPos = (num + 1) * getHeight() / 4;
            colour = Color.GREEN;
        }

        public void run()
        {
            try
            {
                while (true)
                {
                    xPos = xPos + speed;
                    if (xPos > getWidth())
                    {
                        xPos = -20;
                    }
                    else if (xPos > 400 && xPos < 700)
                    {
                        colour = Color.RED;
                        goThroughNarrows(this);
                    }
                    Thread.sleep((int) (Math.random() * 50));
                }
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }

        public void advance()
        {
            xPos += speed;
        }

        public int getXPos()
        {
            return xPos;
        }

        public void setInNarrows(boolean inNarrows)
        {
            if (inNarrows)
            {
                yPos = (int) ((2.5) * getHeight() / 4);
                colour = Color.BLUE;
            }
            else
            {
                yPos = (num + 1) * getHeight() / 4;
                colour = Color.GREEN;
            }
        }

        /**
         * Paint car
         */
        public void display(Graphics g)
        {

            // Draw two wheels
            g.setColor(Color.BLACK);
            g.fillOval(xPos + 10, yPos - 10, 10, 10);
            g.fillOval(xPos + 30, yPos - 10, 10, 10);

            // Draw the car body
            g.setColor(colour);
            g.fillRect(xPos, yPos - 20, 50, 10);

            // Draw the top
            g.setColor(Color.RED);
            Polygon polygon = new Polygon();
            polygon.addPoint(xPos + 10, yPos - 20);
            polygon.addPoint(xPos + 20, yPos - 30);
            polygon.addPoint(xPos + 30, yPos - 30);
            polygon.addPoint(xPos + 40, yPos - 20);
            g.fillPolygon(polygon);
        }
    }
}
